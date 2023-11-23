package com.marcusfeitosa.restful_crud_applicattion.respository;

import com.marcusfeitosa.restful_crud_applicattion.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
