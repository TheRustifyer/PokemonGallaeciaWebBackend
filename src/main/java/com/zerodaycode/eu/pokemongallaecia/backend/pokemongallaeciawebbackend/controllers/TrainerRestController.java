package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Trainer;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.ITrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class TrainerRestController {
    
    @Autowired
    private ITrainerService trainerService;

    @GetMapping("/trainers")
    public List<Trainer> trainers() {
        return trainerService.findAll();
    }

    @GetMapping("/trainers/{id}")
    public<T extends Number> Trainer getTrainer(@PathVariable T id) {
        return trainerService.findById((Integer) id).get();
    }

    @PutMapping("/trainers/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public<T extends Number> Trainer updateTrainer(@RequestBody Trainer trainer, @PathVariable T id) {
        Trainer actualTrainer = trainerService.findById((Integer) id).get();

        actualTrainer.setNickname(trainer.getNickname());
        
        return trainerService.save(actualTrainer);
    }

    @DeleteMapping("/trainers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public<T extends Number> void deleteTrainer(@PathVariable T id) {
        trainerService.deleteTrainer(id);
    }

    public TrainerRestController() {}
}
