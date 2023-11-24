package com.marcusfeitosa.restful_crud_applicattion.mapper;

import com.marcusfeitosa.restful_crud_applicattion.dto.UserDTO;
import com.marcusfeitosa.restful_crud_applicattion.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
    
    public static User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }
}
