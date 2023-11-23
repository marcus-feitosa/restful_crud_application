package com.marcusfeitosa.restful_crud_applicattion.controller;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.respository.UserRepository;
import com.marcusfeitosa.restful_crud_applicattion.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;
    @PostMapping ("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
