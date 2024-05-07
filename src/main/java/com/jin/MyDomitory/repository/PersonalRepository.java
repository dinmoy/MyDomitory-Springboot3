package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal,Long> {
    List<Personal> findByUserId(Long userId);
}
