package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service;

import java.util.List;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.dao.ICityDao;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ICityServiceImpl implements ICityService {
    
    @Autowired
    private ICityDao cityDao;

    @Override
    @Transactional(readOnly = true)
    public List<City> getGameCities() {
        return (List<City>) cityDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public City findById(int id) {
        return cityDao.findById(id).get();
    }

    @Override
    @Transactional
    public City save(City city) {
        return cityDao.save(city);
    }

    @Override
    @Transactional
    public void delete(int id) {
        cityDao.deleteById(id);
    }
}
