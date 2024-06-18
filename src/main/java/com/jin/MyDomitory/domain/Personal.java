package com.jin.MyDomitory.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long score;

    @Column(nullable = false)
    private LocalDate date;

    @Builder
    public Personal(Long userId,String type,String content,Long score,LocalDate date){
        this.userId=userId;
        this.type=type;
        this.content=content;
        this.score=score;
        this.date=date;
    }
}
