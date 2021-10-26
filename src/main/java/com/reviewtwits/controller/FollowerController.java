package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.reviewtwits.entity.Follower;
import com.reviewtwits.service.FollowerService;
import com.reviewtwits.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/follower")
public class FollowerController {
    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    FollowerService followerService;

    @PostMapping("")
    private Follower submitFollower(@RequestBody Follower follower) {
        return followerService.submitFollowerToDataBase(follower);
    }

    @DeleteMapping("/{targetUid}")
    private int deleteFollower(@PathVariable("targetUid") String targetUid, @RequestHeader("Authorization") String authorization) {
        return followerService.deleteFollowerFromDatabase(TokenUtil.parseUid(firebaseAuth, authorization), targetUid);
    }

    @GetMapping("")
    private ArrayList<Follower> getFollowerByUid(@RequestHeader("Authorization") String authorization) {
        return followerService.displayFollowersFromUid(TokenUtil.parseUid(firebaseAuth, authorization));
    }

    @GetMapping("/followed/{targetUid}")
    private ArrayList<Follower> getFollowedByTargetUid(@PathVariable("targetUid")String targetUid) {
        return followerService.displayFollowersFromTarget(targetUid);
    }
}
