package com.reviewtwits.service;

import com.reviewtwits.entity.Follower;
import com.reviewtwits.repository.FollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class FollowerService {

    FollowerRepo followerRepo;

    public FollowerService(FollowerRepo followerRepo) {
        this.followerRepo = followerRepo;
    }

    public Follower submitFollowerToDataBase(Follower follower) {
        return followerRepo.save(follower);
    }

    @Transactional
    public int deleteFollowerFromDatabase(String uid, String targetUid) {
        Follower follower = followerRepo.findFollowerByUidAndTargetUid(uid, targetUid);
        if(follower == null || !follower.getUid().equals(uid))
            return -1;
        followerRepo.deleteFollowerByUidAndTargetUid(uid, targetUid);
        return 0;
    }

    public ArrayList<Follower> displayFollowersFromUid(String uid) {
        return followerRepo.findFollowerByUid(Sort.by(Sort.Direction.DESC, "followId"), uid);
    }

    public ArrayList<Follower> displayFollowersFromTarget(String targetUid) {
        return followerRepo.findFollowerByTargetUid(Sort.by(Sort.Direction.DESC, "followId"), targetUid);
    }
}
