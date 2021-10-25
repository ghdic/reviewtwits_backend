package com.reviewtwits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name="project")
@Data
public class Project {
    @Id
    private String projectId;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uid;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_uid")
    private User user;
    private String summary;
    private String category;
    private String domain;
    private int reviewStyle;
    @Column(length = 1024)
    private String customCss;
    private int aiPositiveNegative;
}
