package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Laundry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaundryRepository extends JpaRepository<Laundry,Long> {
    List<Laundry> findByUserId(Long userId);
}
