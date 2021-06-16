package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Game;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IGameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class GameRestController {
    
    @Autowired
    private IGameService gameService;

    @GetMapping("/Game")
    public Game getGame() {
        return gameService.getGame().get();
    }
}
