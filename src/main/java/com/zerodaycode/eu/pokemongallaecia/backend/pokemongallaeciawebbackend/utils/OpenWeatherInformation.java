package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils;

import java.net.http.HttpResponse;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data.Data;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data.GameCity;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.Weather;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenWeatherInformation extends Networking {
    
    private String weatherKey = "weather";

    private final static String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final static String CONFIG_PARAMS = ",es&lang=es&appid=";
    private final static String APP_ID = Data.OPENWEATHER_APP_ID;

    // Empty constructor
    public OpenWeatherInformation() {}

    private String cityToOpenWeatherUrl(String city) {
        return OpenWeatherInformation.OPEN_WEATHER_URL + city +  OpenWeatherInformation.CONFIG_PARAMS + OpenWeatherInformation.APP_ID;
    }

    public Weather getCityWeather(GameCity city) throws Exception {
        String cityToUrl;
        
        if (city.hasAvailiableWeatherRequest()) {
            cityToUrl = this.cityToOpenWeatherUrl(city.toUrl());
        } else {
            cityToUrl = this.cityToOpenWeatherUrl(city.getCityProvince().toUrl());
        }

        HttpResponse<String> weatherInfo = super.makeGetRequest(cityToUrl);

        String body = weatherInfo.body();

        JsonHandling jsonData = new JsonHandling();
        JSONArray parsedArray = jsonData.getJsonArrayFromString(body, this.weatherKey);

        // Weather always comes at index 0 of that specific JSONArray
        JSONObject jsonWeather = (JSONObject) parsedArray.get(0);

        // Make a new weather object for the designed city
        int weatherIdCode = jsonWeather.getInt("id");
        String mainCode = (String) jsonWeather.get("main");
        String description = (String) jsonWeather.get("description");
        String icon = (String) jsonWeather.get("icon");

        Weather weather = new Weather(weatherIdCode, mainCode, description, icon);

        return weather;
    }
}
