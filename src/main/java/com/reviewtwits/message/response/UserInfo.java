package com.reviewtwits.message.response;

import com.reviewtwits.domain.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserInfo {
    public String uid;
    private String nickname;
    private String profileImage;
    private LocalDate birthday;
    private int age;
    private int gender;

    public UserInfo(User user) {
        this.uid = user.getUsername();
        this.nickname = user.getNickname();
        this.profileImage = user.getProfileImage();
        this.birthday = user.getBirthday();
        this.age = user.getAge();
        this.gender = user.getGender();
    }
}
