package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CleaningRepository extends JpaRepository<Cleaning,Long> {
    List<Cleaning> findByDate(LocalDate date);
}
