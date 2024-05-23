package com.jin.MyDomitory.dto.personal;

import com.jin.MyDomitory.domain.Personal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonalResponse {
    private Long userId;
    private String type;
    private String content;
    private Long score;
    private LocalDate date;

    public PersonalResponse(Personal personal){
        this.userId=personal.getUserId();
        this.type=personal.getType();
        this.content=personal.getContent();
        this.score=personal.getScore();
        this.date=personal.getDate();
    }
}
