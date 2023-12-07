package com.marcusfeitosa.restful_crud_applicattion.controller;

import com.marcusfeitosa.restful_crud_applicattion.dto.UserDTO;
import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.respository.UserRepository;
import com.marcusfeitosa.restful_crud_applicattion.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @PostMapping ("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }
    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public UserDTO updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        userService.updateUser(userDTO);
        return userDTO;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUseryId(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public List<UserDTO> getAll(){
        return userService.gettAll();
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
