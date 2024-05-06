package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.user.AddUserRequest;
import com.jin.MyDomitory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        User newUser=userService.AddUser(request);
        return (newUser!=null)?
                ResponseEntity.status(HttpStatus.OK).body((newUser)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
