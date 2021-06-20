package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;
import java.util.Optional;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao.ITrainerDao;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ITrainerServiceImpl implements ITrainerService {
    
    @Autowired
    private ITrainerDao trainerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Trainer> findAll() {
        return (List<Trainer>) this.trainerDao.findAll();
    }

    
    @Override
    @Transactional(readOnly = true)
    public<T extends Number> Optional<Trainer> findById(T id) {
        return this.trainerDao.findById((Integer) id);
    }

    @Override
    @Transactional
    public Trainer save(Trainer trainer) {
        return trainerDao.save(trainer);
    }

    @Override
    @Transactional
    public <T extends Number> void deleteTrainer(T id) {
        trainerDao.deleteById((Integer) id);
    }
}
