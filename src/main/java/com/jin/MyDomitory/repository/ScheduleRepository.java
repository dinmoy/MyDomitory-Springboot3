package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
