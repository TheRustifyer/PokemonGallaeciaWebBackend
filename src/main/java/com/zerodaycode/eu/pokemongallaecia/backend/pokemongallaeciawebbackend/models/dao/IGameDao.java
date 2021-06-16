package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Game;

import org.springframework.data.repository.CrudRepository;

public interface IGameDao extends CrudRepository<Game, Integer> { }
