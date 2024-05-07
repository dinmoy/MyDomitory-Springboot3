package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Board;
import com.jin.MyDomitory.dto.board.AddBoardRequest;
import com.jin.MyDomitory.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<Board> addBoard(@RequestBody AddBoardRequest request){
        Board newBoard=boardService.addBoard(request);
        return (newBoard!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body((newBoard)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
