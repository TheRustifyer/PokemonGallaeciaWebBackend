package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Trainer;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.ITrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class TrainerRestController {
    
    @Autowired
    private ITrainerService gamerService;

    @GetMapping("/trainers")
    public List<Trainer> gamers() {
        return gamerService.findAll();
    }

    public TrainerRestController() {}
}
