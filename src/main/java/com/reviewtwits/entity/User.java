package com.reviewtwits.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name="user")
@Data
public class User{
    @Id
    @Column(length = 512)
    private String uid;
    @Column(unique = true)
    private String nickname;
    private String content;
    private String profileImage;
    private LocalDate birthday;
    private int age;
    private int gender;
    @ColumnDefault("1")
    private int grade;
    @ColumnDefault("1")
    private int reviewReveal;

    public User() {
        super();
    }

    public User(String uid, String nickname, String profileImage, LocalDate birthday, int age, int gender, int grade, int reviewReveal) {
        this.uid = uid;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.reviewReveal = reviewReveal;
    }
}
