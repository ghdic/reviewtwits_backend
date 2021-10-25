package com.reviewtwits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue
    int productId;
    String path;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String projectId;
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_projectId")
    private Project project;
    @ColumnDefault("0")
    int sales;
    @ColumnDefault("0")
    int reviews;
    @ColumnDefault("0")
    int income;
    @ColumnDefault("0")
    int view;
    String goodsName;
    int price;
}
