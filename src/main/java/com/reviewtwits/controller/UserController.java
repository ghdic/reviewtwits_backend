package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.reviewtwits.entity.User;
import com.reviewtwits.message.request.RegisterInfo;
import com.reviewtwits.message.response.UserInfo;
import com.reviewtwits.service.UserService;
import com.reviewtwits.util.RequestUtil;
import com.reviewtwits.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    private UserService userService;

    @GetMapping("")
    private ArrayList<User> getAllUser() {
        return userService.getAllUserData();
    }

    @PostMapping("")
    public User register(@RequestHeader("Authorization") String authorization,
                             @RequestBody RegisterInfo registerInfo) {

        User registeredUser = userService.register(
                TokenUtil.parseUid(firebaseAuth, authorization), registerInfo.getNickname(),
                registerInfo.getProfileImage(), LocalDate.parse(registerInfo.getBirthday(), DateTimeFormatter.ISO_DATE), registerInfo.getAge(), registerInfo.getGender(), registerInfo.getReviewReveal());
        return registeredUser;
    }

    @GetMapping("/{uid}")
    private User getUserDetails(@PathVariable("uid") String uid) {
        return userService.loadUserByUsername(uid);
    }

    @PostMapping("/{uid}")
    private User updateUser(@RequestHeader("Authorization") String authorization, @RequestBody RegisterInfo registerInfo) {

        return userService.updateUserData(TokenUtil.parseUid(firebaseAuth, authorization), registerInfo.getNickname(), registerInfo.getProfileImage(),
                LocalDate.parse(registerInfo.getBirthday(), DateTimeFormatter.ISO_DATE), registerInfo.getAge(), registerInfo.getGender(), registerInfo.getReviewReveal());
    }

    @GetMapping("/self")
    public User getUserSelf(@RequestHeader("Authorization") String authorization) {
        return userService.loadUserByUsername(TokenUtil.parseUid(firebaseAuth, authorization));
    }

    @GetMapping("/suggestions")
    private ArrayList<User> suggetionUsers() {
        return userService.getRecentlyRegisterUser();
    }
}
