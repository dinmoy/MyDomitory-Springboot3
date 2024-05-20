package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Board;
import com.jin.MyDomitory.dto.board.AddBoardRequest;
import com.jin.MyDomitory.dto.board.BoardResponse;
import com.jin.MyDomitory.dto.board.UpdateBoardRequest;
import com.jin.MyDomitory.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
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
