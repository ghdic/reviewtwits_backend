package com.reviewtwits.repository;

import com.reviewtwits.entity.Follower;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FollowerRepo extends JpaRepository<Follower, Integer> {
    Follower save(Follower follower);
    Follower findFollowerByFollowId(int followId);
    Follower findFollowerByUidAndTargetUid(String uid, String targetUid);
    ArrayList<Follower> findFollowerByUid(Sort sort, String uid);
    ArrayList<Follower> findFollowerByTargetUid(Sort sort, String targetUid);
    void deleteFollowerByUidAndTargetUid(String uid, String targetUid);
}
