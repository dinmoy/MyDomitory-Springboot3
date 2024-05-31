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

    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false,length = 15)
    private Long washer_num;

    @Column(nullable = false,length = 15)
    private Long room_num;

    public Laundry(){}
    @Builder
    public Laundry(Long userId,Long washer_num, Long room_num){
        this.userId=userId;
        this.washer_num=washer_num;
        this.room_num=room_num;
    }

}


