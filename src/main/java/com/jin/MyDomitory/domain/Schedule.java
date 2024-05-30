package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private boolean progress=false;

    @Builder
    public Schedule(String content, LocalDate date, boolean progress) {
        this.content = content;
        this.date = date;
        this.progress = progress;
    }

}
