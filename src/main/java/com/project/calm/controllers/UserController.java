package com.project.calm.controllers;


import com.project.calm.dto.UserDTO;
import com.project.calm.entities.User;
import com.project.calm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer id){
        return ResponseEntity.ok(userService.updadateUser(userDTO, id));
    }
}
