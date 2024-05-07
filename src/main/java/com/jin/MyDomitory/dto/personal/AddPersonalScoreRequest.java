package com.jin.MyDomitory.dto.personal;

import com.jin.MyDomitory.domain.Personal;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPersonalScoreRequest {
    private Long userId;
    private String content;
    private Long score;

    public Personal toEntity(){
        return Personal.builder()
                .userId(userId)
                .content(content)
                .score(score)
                .build();
    }
}
