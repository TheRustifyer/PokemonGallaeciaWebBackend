package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Gamer;

public interface IGamerService {
    
    public List<Gamer> findAll();
}
