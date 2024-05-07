package com.jin.MyDomitory.repository;
import com.jin.MyDomitory.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmailAndPassword(String email, String password);
}
