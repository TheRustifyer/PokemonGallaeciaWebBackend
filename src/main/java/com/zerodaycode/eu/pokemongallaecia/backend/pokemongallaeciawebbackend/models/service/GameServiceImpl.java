package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao.IGameDao;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameServiceImpl implements IGameService {
    
    @Autowired
    private IGameDao gameDao;

    @Override
    public Optional<Game> getGame() {
        // Only exists ONE game, so always want the ID = 1
        return gameDao.findById(1);
    }

    @Override
    public Game save(Game game) {
        return gameDao.save(game);
    }

    @Override
    public void delete(int id) {
        gameDao.deleteById(id);
    }

}
