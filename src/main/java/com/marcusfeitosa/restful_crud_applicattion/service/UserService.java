package com.marcusfeitosa.restful_crud_applicattion.service;

import com.marcusfeitosa.restful_crud_applicattion.dto.UserDTO;
import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import com.marcusfeitosa.restful_crud_applicattion.exception.ResourceNotFoundException;
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


    public UserDTO getUserById(Long id) {
       User user = userRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("User", "id", id)
       );
       return UserMapper.mapToUserDTO(user);
    }


    public List<UserDTO> gettAll() {
        List<User> users =  userRepository.findAll();
        return users
                .stream()
                .map(UserMapper::mapToUserDTO)
                .toList();
    }


    public UserDTO updateUser(UserDTO userDTO) {
        User actualUser = userRepository.findById(userDTO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDTO.getId())
        );
        actualUser.setFirstName(userDTO.getFirstName());
        actualUser.setLastName(userDTO.getLastName());
        actualUser.setEmail(userDTO.getEmail());
        User updatedUser =  userRepository.save(actualUser);
        return UserMapper.mapToUserDTO(updatedUser);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
