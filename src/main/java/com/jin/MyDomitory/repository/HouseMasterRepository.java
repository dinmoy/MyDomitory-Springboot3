package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Housemaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HouseMasterRepository extends JpaRepository<Housemaster,Long> {
    List<Housemaster> findByDate(LocalDate date);
}
