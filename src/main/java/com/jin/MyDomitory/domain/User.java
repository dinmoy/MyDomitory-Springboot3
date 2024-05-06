package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false)
    private String room_num;

    @Column
    private String profile_img;

    @Builder
    public User(String name,String email,String password,String type,String school,String room_num,String profile_img) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.school=school;
        this.room_num=room_num;
        this.profile_img = profile_img;
    }
}
