package com.reviewtwits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity(name="order")
@Data
public class Order {
    @Id
    @GeneratedValue
    int orderId;
    String domainUrl;
    String projectId;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uid")
    private User user;
    String goodsName;
    int price;
    String payment; // Paid, Due
    String status; // complete, pending, return, in progress
}
