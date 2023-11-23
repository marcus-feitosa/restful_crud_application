package com.marcusfeitosa.restful_crud_applicattion.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
}
