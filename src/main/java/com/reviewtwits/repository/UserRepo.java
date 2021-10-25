package com.reviewtwits.repository;

import com.reviewtwits.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User save(User user);
    ArrayList<User> findAll();
    ArrayList<User> findFirst10ByOrderByUidDesc();
    User findByUid(String uid);
}
