package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.user.AddUserRequest;
import com.jin.MyDomitory.dto.user.LoginUserRequest;
import com.jin.MyDomitory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User AddUser(AddUserRequest request){
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        return userRepository.save(request.toEntity());
    }

    public User Login(LoginUserRequest request){
        User user=userRepository.findByEmail(request.getEmail());
        if(user==null || !bCryptPasswordEncoder.matches((request.getPassword()),user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return user;
    }


    public List<User> findById(Long userId){
        return userRepository.findAllById(userId);
    }

}
