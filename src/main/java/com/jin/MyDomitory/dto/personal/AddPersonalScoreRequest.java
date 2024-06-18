package com.jin.MyDomitory.dto.personal;

import com.jin.MyDomitory.domain.Personal;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPersonalScoreRequest {
    private Long userId;
    private String type;
    private String content;
    private Long score;
    private LocalDate date;

    public Personal toEntity(){
        return Personal.builder()
                .userId(userId)
                .type(type)
                .content(content)
                .score(score)
                .date(date)
                .build();
    }
}
