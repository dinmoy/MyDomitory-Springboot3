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
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int score;

    @Builder
    public Personal(int userId,String content,int score){
        this.userId=userId;
        this.content=content;
        this.score=score;
    }
}
