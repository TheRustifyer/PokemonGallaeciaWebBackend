package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils;

import java.util.ArrayList;
import java.util.List;

public enum GameCity {
    
    SANTIAGO_DE_COMPOSTELA,
    A_CORUÑA;

    public static List<GameCity> allCities() {
        List<GameCity> allCities = new ArrayList<>();
        for (GameCity city : GameCity.values()) {
            allCities.add(city);
        }
        return allCities;
    }

}
