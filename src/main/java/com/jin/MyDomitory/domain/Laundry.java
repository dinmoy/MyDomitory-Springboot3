package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Laundry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(nullable = false,length = 15)
    private String washer_num;

    @Column(nullable = false,length = 15)
    private String room_num;

    @Builder
    public Laundry(String washer_num, String room_num){
        this.washer_num=washer_num;
        this.room_num=room_num;
    }

}


