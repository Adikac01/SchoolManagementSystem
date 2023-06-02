package com.example.school.Database.User;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private final String type = "user";

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/id/{id}")
    public @ResponseBody User getUserById(@PathVariable String id){
        Integer userId = Integer.parseInt(id);
        return userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(userId, type));
    }
    @GetMapping("/name/{name}")
    public @ResponseBody Iterable<User> getUserByName(@PathVariable String name){
        return userRepository.findByUsername(name);
    }
}
