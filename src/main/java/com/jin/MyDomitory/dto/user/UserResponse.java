package com.jin.MyDomitory.dto.user;

import com.jin.MyDomitory.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String school;
    private String room_num;
    private String profile_img;
    public UserResponse(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.type=user.getType();
        this.school=user.getSchool();
        this.room_num=user.getRoom_num();
        this.profile_img=user.getProfile_img();
    }
}
