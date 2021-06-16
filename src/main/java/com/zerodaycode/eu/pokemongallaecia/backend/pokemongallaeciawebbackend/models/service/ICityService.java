package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.City;

public interface ICityService {
    
    public List<City> getGameCities();

    public City findById(int id);

    public City save(City city);

    public void delete(int id);

}
