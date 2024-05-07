package com.jin.MyDomitory.domain;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Post(){}
    public Post(String title,String content){
        this.title=title;
        this.content=content;
    }
}
