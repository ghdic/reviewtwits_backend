package com.reviewtwits.service;

import com.reviewtwits.entity.User;
import com.reviewtwits.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User loadUserByUsername(String uid) throws UsernameNotFoundException {
        return userRepo.findByUid(uid);
    }

    public User register(String uid, String nickname, String profileImage, LocalDate birthday, int age, int gender, int reviewReveal) {
        User user = new User();
        user.setUid(uid);
        user.setNickname(nickname);
        user.setProfileImage(profileImage);
        user.setBirthday(birthday);
        user.setAge(age);
        user.setGender(gender);
        user.setReviewReveal(reviewReveal);
        return userRepo.save(user);
    }

    public User updateUserData(String uid, String nickname, String profileImage, LocalDate birthday, int age, int gender, int reviewReveal) {
        User user = userRepo.findByUid(uid);

        if(user == null)
            return null;

        user.setNickname(nickname);
        user.setProfileImage(profileImage);
        user.setBirthday(birthday);
        user.setAge(age);
        user.setGender(gender);
        user.setReviewReveal(reviewReveal);
        return userRepo.save(user);
    }

    public ArrayList<User> getAllUserData() {
        return userRepo.findAll();
    }

    public ArrayList<User> getRecentlyRegisterUser() {
        return userRepo.findFirst10ByOrderByUidDesc();
    }
}
