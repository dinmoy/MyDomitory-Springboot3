package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findByDate(LocalDate date);
}
