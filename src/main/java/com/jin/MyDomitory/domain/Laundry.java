package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Laundry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false,length = 15)
    private String washer_num;

    @Column(nullable = false,length = 15)
    private String room_num;

    @Column(nullable = false)
    private LocalDateTime wash_time;

    public Laundry(){}
    @Builder
    public Laundry(Long userId,String washer_num, String room_num,LocalDateTime wash_time){
        this.userId=userId;
        this.washer_num=washer_num;
        this.room_num=room_num;
        this.wash_time=wash_time;
    }

}


