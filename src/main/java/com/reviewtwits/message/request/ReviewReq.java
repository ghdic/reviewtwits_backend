package com.reviewtwits.message.request;

import lombok.Data;

@Data
public class ReviewReq {
    String imagePath;
    String content;
    int score;
}
