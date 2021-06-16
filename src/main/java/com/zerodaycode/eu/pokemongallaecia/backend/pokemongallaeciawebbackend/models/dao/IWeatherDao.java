package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Weather;

import org.springframework.data.repository.CrudRepository;


public interface IWeatherDao extends CrudRepository<Weather, Integer> { }
