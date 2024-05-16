package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.user.AddUserRequest;
import com.jin.MyDomitory.dto.user.LoginUserRequest;
import com.jin.MyDomitory.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User AddUser(AddUserRequest request){
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        return userRepository.save(request.toEntity());
    }

    public User Login(LoginUserRequest dto, HttpServletRequest request){
        User user=userRepository.findByEmail(dto.getEmail());
        HttpSession session=request.getSession();
        if(user!=null &&bCryptPasswordEncoder.matches(dto.getPassword(),user.getPassword())){
            session.setAttribute("loggedUser",user);
            return user;
        }
        return null;
    }

    public List<User> findById(Long userId){
        return userRepository.findAllById(userId);
    }

}
