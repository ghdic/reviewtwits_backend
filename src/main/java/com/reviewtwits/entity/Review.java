package com.reviewtwits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "review")
@Data
public class Review {
    @Id
    @GeneratedValue
    private int reviewId;

    @ColumnDefault("0")
    private int reviewType; // 0 인증x, 1 인증
    private String projectId;
    private String path;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name = "user_uid") // 멤버변수이름_외래키이름
    private User user;
    @Column(length = 1024)
    private String imagePath;
    @Column(length = 2048)
    private String content;
    private int score;
    private double emotion;
    private LocalDateTime createDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ColumnDefault("0")
    private int likeCount;
}
