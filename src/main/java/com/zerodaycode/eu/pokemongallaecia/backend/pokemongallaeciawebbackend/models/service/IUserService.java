package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;

public interface IUserService {
    
    public List<User> findAll();
}
