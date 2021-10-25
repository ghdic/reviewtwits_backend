package com.reviewtwits.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "follow")
@Data
public class Follower {
    @Id
    @GeneratedValue
    private int followId;
    private String uid;
    private String targetUid;
}
