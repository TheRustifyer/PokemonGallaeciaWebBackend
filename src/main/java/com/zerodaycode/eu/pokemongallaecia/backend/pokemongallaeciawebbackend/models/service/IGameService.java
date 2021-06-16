package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.Optional;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Game;

public interface IGameService {
    
    public Optional<Game> getGame();

    public Game save(Game game);

    public void delete(int id);

}
