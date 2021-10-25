package com.reviewtwits.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Collection;

@Entity(name="user")
@Data
public class User implements UserDetails {
    @Id
    @Column(length = 512)
    private String uid;
    @Column(unique = true)
    private String nickname;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return uid;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
