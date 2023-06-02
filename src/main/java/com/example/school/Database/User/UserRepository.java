package com.example.school.Database.User;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByUsername(String username);
}
