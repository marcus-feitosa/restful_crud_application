package com.marcusfeitosa.restful_crud_applicattion.service.impl;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.respository.UserRepository;
import com.marcusfeitosa.restful_crud_applicattion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.findById(id).get();
    }

    @Override
    public List<User> gettAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User actualUser = userRepository.findById(user.getId()).get();
        actualUser.setFirstName(user.getFirstName());
        actualUser.setLastName(user.getLastName());
        actualUser.setEmail(user.getEmail());
        return userRepository.save(actualUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
