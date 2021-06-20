package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public<T extends Number> User getUser(@PathVariable T id) {
        return userService.findById((Integer) id).get();
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public<T extends Number> User updateUser(@RequestBody User user, @PathVariable T id) {
        User actualUser = userService.findById((Integer) id).get();

        actualUser.setUsername(user.getUsername());
        actualUser.setPassword(user.getPassword());
        actualUser.setEmail(user.getEmail());
        actualUser.setName(user.getName());
        actualUser.setLastName(user.getLastName());
        
        return userService.save(actualUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public<T extends Number> void deleteUser(@PathVariable T id) {
        userService.delete(id);
    }

    public UserRestController() {}
}
