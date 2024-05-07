package com.jin.MyDomitory.dto.board;

import com.jin.MyDomitory.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddBoardRequest {
    private Long userId;
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .build();

    }
}
