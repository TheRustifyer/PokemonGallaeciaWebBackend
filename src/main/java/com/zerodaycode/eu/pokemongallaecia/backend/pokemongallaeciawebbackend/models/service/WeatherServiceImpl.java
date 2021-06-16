package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao.IWeatherDao;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class WeatherServiceImpl implements IWeatherService {
    
    @Autowired
    private IWeatherDao weatherDao;

    @Override
    @Transactional(readOnly = true)
    public List<Weather> getAllWeathers() {
        return (List<Weather>) weatherDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Weather findById(int id) {
        return weatherDao.findById(id).get();
    }

    @Override
    @Transactional
    public Weather save(Weather weather) {
        return weatherDao.save(weather);
    }

    @Override
    @Transactional
    public void delete(int id) {
        weatherDao.deleteById(id);
    }
}
