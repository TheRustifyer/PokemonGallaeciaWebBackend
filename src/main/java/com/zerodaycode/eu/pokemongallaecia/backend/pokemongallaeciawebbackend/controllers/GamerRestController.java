package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Gamer;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IGamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GamerRestController {
    
    @Autowired
    private IGamerService gamerService;

    @GetMapping("/gamers")
    public List<Gamer> gamers() {
        return gamerService.findAll();
    }

    public GamerRestController() {}
}
