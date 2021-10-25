package com.reviewtwits.message.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterInfo {
    private String nickname;
    private String profileImage;
    private String birthday;
    private int age;
    private int gender;
    private int reviewReveal;
}
