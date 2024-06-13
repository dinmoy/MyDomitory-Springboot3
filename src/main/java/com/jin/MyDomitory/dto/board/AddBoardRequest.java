package com.jin.MyDomitory.dto.board;

import com.jin.MyDomitory.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddBoardRequest {
    private Long userId;
    private String type;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Board toEntity(){
        return Board.builder()
                .userId(userId)
                .type(type)
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .build();

    }
}
