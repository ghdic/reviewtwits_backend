package com.reviewtwits.service;

import com.reviewtwits.entity.User;
import com.reviewtwits.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User loadUserByUsername(String uid) {
        User user = userRepo.findByUid(uid);
        if(user == null) {
            User newUser = new User();
            newUser.setUid("0");
            return newUser;
        }
        return user;
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
