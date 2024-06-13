package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Optional<Board> findFirstByCreatedAtLessThanOrderByCreatedAtDesc(LocalDateTime createdAt);
}
