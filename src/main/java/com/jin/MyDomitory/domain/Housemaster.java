package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Housemaster {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private LocalDate date;

    public Housemaster() {
    }

    @Builder
    public Housemaster(String teacherName,LocalDate date){
        this.teacherName=teacherName;
        this.date=date;
    }
}
