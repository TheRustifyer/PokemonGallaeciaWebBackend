package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

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
}
