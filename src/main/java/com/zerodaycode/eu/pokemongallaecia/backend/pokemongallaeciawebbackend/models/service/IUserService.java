package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;
import java.util.Optional;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IUserService {
    
    public List<User> findAll();

    public Page<User> findAll(Pageable pageable);

    public<T extends Number> Optional<User> findById(T id);

    public User save(User user);

    public<T extends Number> void delete(T id);

}
