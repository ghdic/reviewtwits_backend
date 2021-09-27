package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.reviewtwits.domain.User;
import com.reviewtwits.message.request.RegisterInfo;
import com.reviewtwits.message.response.UserInfo;
import com.reviewtwits.service.UserService;
import com.reviewtwits.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    private UserService userService;

    @PostMapping("")
    public UserInfo register(@RequestHeader("Authorization") String authorization,
                             @RequestBody RegisterInfo registerInfo) {
        FirebaseToken decodedToken;
        try {
            String token = RequestUtil.getAuthorizationToken(authorization);
            decodedToken = firebaseAuth.verifyIdToken(token);
        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
        }
        User registeredUser = userService.register(
                decodedToken.getUid(), decodedToken.getEmail(), registerInfo.getNickname());
        return new UserInfo(registeredUser);
    }

    @GetMapping("self")
    public UserInfo getUserSelf(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return new UserInfo(user);
    }
}
