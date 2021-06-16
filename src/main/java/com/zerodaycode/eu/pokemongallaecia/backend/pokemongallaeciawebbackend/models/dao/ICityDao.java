package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.City;

import org.springframework.data.repository.CrudRepository;

public interface ICityDao extends CrudRepository<City, Integer> {
    
}
