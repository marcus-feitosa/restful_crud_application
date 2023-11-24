package com.marcusfeitosa.restful_crud_applicattion.controller;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.respository.UserRepository;
import com.marcusfeitosa.restful_crud_applicattion.service.impl.UserServiceImpl;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/user/{id}")
    @Transactional
    public ResponseEntity updateUser(
            @PathVariable Long id,
            @RequestBody User user){
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public User getUseryId(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/user")
    public List<User> getAll(){
        return userService.gettAll();
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
