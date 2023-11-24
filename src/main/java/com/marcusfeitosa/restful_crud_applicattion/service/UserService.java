package com.marcusfeitosa.restful_crud_applicattion.service;

import com.marcusfeitosa.restful_crud_applicattion.dto.UserDTO;
import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.mapper.UserMapper;
import com.marcusfeitosa.restful_crud_applicattion.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }


    public User getUserById(Long id) {
       return userRepository.findById(id).get();
    }


    public List<User> gettAll() {
        return userRepository.findAll();
    }


    public User updateUser(User user) {
        User actualUser = userRepository.findById(user.getId()).get();
        actualUser.setFirstName(user.getFirstName());
        actualUser.setLastName(user.getLastName());
        actualUser.setEmail(user.getEmail());
        return userRepository.save(actualUser);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
