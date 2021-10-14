package com.reviewtwits.service;

import com.reviewtwits.domain.User;
import com.reviewtwits.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        return userRepo.findByUid(uid);
    }

    public User register(String uid, String nickname, String profileImage, LocalDate birthday, int age, int gender) {
        User user = new User(uid, nickname, profileImage, birthday, age, gender);
        userRepo.save(user);
        return user;
    }
}
