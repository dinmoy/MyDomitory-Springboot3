package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Laundry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false,length = 15)
    private String washer_num;

    @Column(nullable = false,length = 15)
    private String room_num;

    public Laundry(){}
    @Builder
    public Laundry(Long userId,String washer_num, String room_num){
        this.userId=userId;
        this.washer_num=washer_num;
        this.room_num=room_num;
    }

}


