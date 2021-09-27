package com.reviewtwits.message.response;

import com.reviewtwits.domain.User;
import lombok.Data;

@Data
public class UserInfo {
    public String uid;
    private String email;
    private String nickname;

    public UserInfo(User user) {
        this.uid = user.getUsername();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
