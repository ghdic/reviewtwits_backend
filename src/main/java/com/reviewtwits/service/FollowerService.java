package com.reviewtwits.service;

import com.reviewtwits.entity.Follower;
import com.reviewtwits.repository.FollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FollowerService {
    @Autowired
    FollowerRepo followerRepo;

    public Follower submitFollowerToDataBase(Follower follower) {
        return followerRepo.save(follower);
    }

    public int deleteFollowerFromDatabase(String uid, int followId) {
        Follower follower = followerRepo.findFollowerByFollowId(followId);
        if(follower == null || !follower.getUid().equals(uid))
            return -1;
        followerRepo.deleteFollowerByFollowId(followId);
        return 0;
    }

    public ArrayList<Follower> displayFollowersFromUid(String uid) {
        return followerRepo.findFollowerByUid(Sort.by(Sort.Direction.DESC, "followId"), uid);
    }

    public ArrayList<Follower> displayFollowersFromTarget(String targetUid) {
        return followerRepo.findFollowerByTargetUid(Sort.by(Sort.Direction.DESC, "followId"), targetUid);
    }
}
