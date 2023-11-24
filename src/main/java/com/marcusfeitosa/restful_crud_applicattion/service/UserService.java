package com.marcusfeitosa.restful_crud_applicattion.service;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> gettAll();

    User updateUser(User user);

    void deleteUser(Long id);
}
