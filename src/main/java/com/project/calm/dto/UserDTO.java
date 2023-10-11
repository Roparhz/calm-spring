package com.project.calm.dto;

import com.project.calm.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String password;

    public UserDTO(){}

    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User toUser(){
        User user = new User();
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }
}
