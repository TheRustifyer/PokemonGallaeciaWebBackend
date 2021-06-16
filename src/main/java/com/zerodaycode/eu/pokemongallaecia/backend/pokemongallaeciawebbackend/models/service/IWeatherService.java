package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Weather;

public interface IWeatherService {
    
    public List<Weather> getAllWeathers();

    public Weather findById(int id);

    public Weather save(Weather weather);

    public void delete(int id);
}
