package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Board;
import com.jin.MyDomitory.dto.board.AddBoardRequest;
import com.jin.MyDomitory.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board addBoard(AddBoardRequest request) {
        return boardRepository.save(request.toEntity());
    }
}
