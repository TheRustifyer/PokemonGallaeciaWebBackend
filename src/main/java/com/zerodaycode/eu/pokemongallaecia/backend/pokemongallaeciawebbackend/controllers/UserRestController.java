package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    public UserRestController() {}
}
