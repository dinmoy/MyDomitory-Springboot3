package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Board;
import com.jin.MyDomitory.dto.board.AddBoardRequest;
import com.jin.MyDomitory.dto.board.BoardResponse;
import com.jin.MyDomitory.dto.board.UpdateBoardRequest;
import com.jin.MyDomitory.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> findAllBoards(){
        List<BoardResponse> boards=boardService.findAll()
                .stream()
                .map(BoardResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findBoardById(@PathVariable("id") Long id){
        Board board=boardService.findById(id);
        BoardResponse boardResponse = new BoardResponse(board);
        return (board!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(boardResponse):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{id}/previous")
    public ResponseEntity<BoardResponse> findPreviousPost(@PathVariable("id") Long id){
        Board previousPost=boardService.findPreviousPost(id);
        BoardResponse boardResponse = new BoardResponse(previousPost);
        return (previousPost!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(boardResponse):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Board> addBoard(@RequestBody AddBoardRequest request){
        Board newBoard=boardService.addBoard(request);
        return (newBoard!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body((newBoard)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") Long id, @RequestBody UpdateBoardRequest request) {
        Board updatedBoard = boardService.update(id, request);
        return ResponseEntity.ok(updatedBoard);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
