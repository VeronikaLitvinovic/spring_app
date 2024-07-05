package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Optional<Object> findByEmail(String email);

    Users findByUsername(String username);

    Users save(Users user);
    ;
}
