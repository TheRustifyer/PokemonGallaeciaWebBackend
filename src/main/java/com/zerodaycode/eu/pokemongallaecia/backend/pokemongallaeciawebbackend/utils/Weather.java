package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils;

import java.util.List;

public class Weather extends Networking {
    
    private final static String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private String city;
    private final static String CONFIG_PARAMS = ",es&lang=es&appid=";
    private final static String APP_ID = Data.OPENWEATHER_APP_ID;

    private List<GameCity> gameCities = GameCity.allCities();

    // Empty constructor
    public Weather() {}

    public String cityToOpenWeatherUrl(GameCity city) {
        switch (city) {
            case SANTIAGO_DE_COMPOSTELA:
                this.city = "santiago de compostela";
                break;
            case A_CORUÑA:
                this.city = "a coruña";
        }
        return Weather.OPEN_WEATHER_URL + this.city +  Weather.CONFIG_PARAMS + Weather.APP_ID;
    }
}
