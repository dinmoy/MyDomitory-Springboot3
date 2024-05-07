package com.jin.MyDomitory.dto.personal;

import com.jin.MyDomitory.domain.Personal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonalResponse {
    private Long userId;
    private String content;
    private Long score;

    public PersonalResponse(Personal personal){
        this.userId=personal.getUserId();
        this.content=personal.getContent();
        this.score=personal.getScore();
    }
}
