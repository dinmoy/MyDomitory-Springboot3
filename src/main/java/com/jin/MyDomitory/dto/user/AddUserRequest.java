package com.jin.MyDomitory.dto.user;

import com.jin.MyDomitory.domain.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddUserRequest {
    private String name;
    private String email;
    private String password;
    private String type;
    private String school;
    private String room_num;

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .type(type)
                .school(school)
                .room_num(room_num)
                .build();
    }

}
