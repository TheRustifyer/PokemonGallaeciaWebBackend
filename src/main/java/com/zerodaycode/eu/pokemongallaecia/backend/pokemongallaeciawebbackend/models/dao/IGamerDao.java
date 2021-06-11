package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Gamer;

import org.springframework.data.repository.CrudRepository;

public interface IGamerDao extends CrudRepository<Gamer, Integer> {
    
}
