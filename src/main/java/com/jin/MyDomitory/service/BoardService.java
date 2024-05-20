package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Board;
import com.jin.MyDomitory.dto.board.AddBoardRequest;
import com.jin.MyDomitory.dto.board.UpdateBoardRequest;
import com.jin.MyDomitory.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board addBoard(AddBoardRequest request) {
        return boardRepository.save(request.toEntity());
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board update(Long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found with id: " + id));
        board.update(request.getUserId(), request.getType(),request.getTitle(), request.getContent());
        return boardRepository.save(board);
    }

    public void deleteById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found with id: " + id));
        boardRepository.delete(board);
    }
}
