package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonalRepository extends JpaRepository<Personal,Long> {
    List<Personal> findByUserId(Long userId);
}
