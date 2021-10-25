package com.reviewtwits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private int commentId;
    private int reviewId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name = "user_uid") // 멤버변수이름_외래키이름
    private User user;
    @Column(updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createDate;
    private String content;

}
