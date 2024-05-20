package com.jin.MyDomitory.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateBoardRequest {
    private Long userId;
    private String type;
    private String title;
    private String content;
}
