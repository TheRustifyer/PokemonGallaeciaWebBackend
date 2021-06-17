package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.ArrayList;
import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data.GameCity;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.City;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Weather;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepository {
    
    /// Method that loads all the cities availiable in the game based on how many cities are 
    /// already handcoded on the GameCity Enum. This is a way to mantain the system as much
    /// scalable as posible as the unique thing to do to get a new City object is add it on the Enum.
    public static List<City> loadGameCities() {

        List<City> gameCities = new ArrayList<>();
        int counter = 1;
        for (final GameCity city : GameCity.values()) {
            City newCity = new City();
            final Weather cityWeather = new Weather(city);
            newCity.setId(counter ++);
            newCity.setName(city.toString());
            newCity.setWeather(cityWeather);
            gameCities.add(newCity);
        }

        return gameCities;
    }
}
