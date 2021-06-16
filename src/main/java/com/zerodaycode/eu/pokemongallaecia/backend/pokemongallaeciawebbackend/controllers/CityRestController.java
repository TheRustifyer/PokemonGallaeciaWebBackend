package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.City;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.CityRepository;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.ICityService;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IWeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CityRestController {
    
    @Autowired
    private ICityService cityService;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/cities")
    public List<City> getGameCities() {
        List<City> cities = cityRepository.loadGameCities();
        for (City city : cities) {
            weatherService.save(city.getWeather());
            cityService.save(city);
        }
        return cityService.getGameCities();
    }
}
