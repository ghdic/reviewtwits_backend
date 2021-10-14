package com.reviewtwits.repository;

import com.reviewtwits.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    UserDetails findByUid(String uid);
}
