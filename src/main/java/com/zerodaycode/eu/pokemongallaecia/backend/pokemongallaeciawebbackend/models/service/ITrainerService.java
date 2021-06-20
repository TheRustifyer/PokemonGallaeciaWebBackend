package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;
import java.util.Optional;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Trainer;

public interface ITrainerService {
    
    public List<Trainer> findAll();

    public<T extends Number> Optional<Trainer> findById(T id);

    public Trainer save(Trainer trainer);

    public<T extends Number> void deleteTrainer(T id);

}
