package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.user.AddUserRequest;
import com.jin.MyDomitory.dto.user.LoginUserRequest;
import com.jin.MyDomitory.dto.user.UserResponse;
import com.jin.MyDomitory.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        User newUser=userService.AddUser(request);
        return (newUser!=null)?
                ResponseEntity.status(HttpStatus.OK).body((newUser)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/login")
    public ResponseEntity<User> Login(@RequestBody LoginUserRequest dto, HttpServletRequest reqest){
        User loggedUser=userService.Login(dto,reqest);
        return (loggedUser!=null)?
                ResponseEntity.status(HttpStatus.OK).build():
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/profile")
    public ResponseEntity<List<UserResponse>> findByUserId(HttpSession session) {
        User sessionUser = (User) session.getAttribute("loggedUser");
        List<UserResponse> laundryList = userService.findById(sessionUser.getId())
                .stream()
                .map(UserResponse::new)
                .toList();
        if (laundryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body((laundryList));
    }

}
