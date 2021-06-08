package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Integer> {
    
}
