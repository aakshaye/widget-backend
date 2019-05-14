package com.challenge.demo.controller;

import com.challenge.demo.model.Site;
import com.challenge.demo.model.User;
import com.challenge.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return Optional
                .ofNullable(userRepository.findAll())
                .map(sites -> ResponseEntity.ok(sites))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@RequestBody User createUser) {
        createUser.setUserUUID(UUID.randomUUID());
        return userRepository.save(createUser);
    }
}
