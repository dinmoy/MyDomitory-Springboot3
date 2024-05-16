package com.jin.MyDomitory.repository;

import com.jin.MyDomitory.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String email);
        List<User> findAllById(Long userId);
}
