package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Board(){}

    @Builder
    public Board(Long userId, String title, String content){
        this.userId=userId;
        this.title=title;
        this.content=content;
    }

    public void update(Long userId, String title, String content){
        this.userId=userId;
        this.title=title;
        this.content=content;
    }
}
