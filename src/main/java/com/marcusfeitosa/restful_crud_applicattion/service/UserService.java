package com.marcusfeitosa.restful_crud_applicattion.service;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);
}
