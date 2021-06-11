package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao.IGamerDao;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Gamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class IGamerServiceImpl implements IGamerService {
    
    @Autowired
    private IGamerDao gamerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Gamer> findAll() {
        return (List<Gamer>) this.gamerDao.findAll();
    }
}
