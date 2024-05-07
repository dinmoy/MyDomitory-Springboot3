package com.jin.MyDomitory.dto.board;

import com.jin.MyDomitory.domain.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
    private Long userId;
    private String title;
    private String content;

    public BoardResponse(Board board){
        this.userId=board.getUserId();
        this.title=board.getTitle();
        this.content=board.getContent();
    }
}
