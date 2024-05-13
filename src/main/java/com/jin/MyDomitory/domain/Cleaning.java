package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(nullable = false)
    private String roomNum;

    @Column(nullable = false)
    private String cleanPoint;

    @Column(nullable = false)
    private LocalDate date;

    public Cleaning(){ }

    @Builder
    public Cleaning(String roomNum,String cleanPoint,LocalDate date){
        this.roomNum=roomNum;
        this.cleanPoint=cleanPoint;
        this.date=date;
    }
}
