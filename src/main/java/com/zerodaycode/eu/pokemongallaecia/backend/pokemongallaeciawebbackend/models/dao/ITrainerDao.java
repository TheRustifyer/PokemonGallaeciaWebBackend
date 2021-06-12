package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Trainer;

import org.springframework.data.repository.CrudRepository;

public interface ITrainerDao extends CrudRepository<Trainer, Integer> {
    
}
