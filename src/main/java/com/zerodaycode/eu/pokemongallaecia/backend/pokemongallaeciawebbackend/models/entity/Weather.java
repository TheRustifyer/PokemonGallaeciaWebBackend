package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data.GameCity;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils.OpenWeatherInformation;

@Entity
@Table(name = "weather")
public class Weather implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private int weatherIDCode;
    private String mainCode;
    private String description;
    private String icon;

    // Empty constructor
    public Weather() {}

    // Constructor that auto-loads the object fields based on a GameCity Enum variant
    public Weather(GameCity gameCity) {
        OpenWeatherInformation owi = new OpenWeatherInformation();
        try {
            Weather cityWeather = owi.getCityWeather(gameCity);
            this.weatherIDCode = cityWeather.weatherIDCode;
            this.mainCode = cityWeather.mainCode;
            this.description = cityWeather.description;
            this.icon = cityWeather.icon;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // Overload
    public Weather(int weatherIDCode, String mainCode, String description, String icon) {
        this.weatherIDCode = weatherIDCode;
        this.mainCode = mainCode;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeatherIDCode() {
        return weatherIDCode;
    }

    public void setWeatherIDCode(int weatherIDCode) {
        this.weatherIDCode = weatherIDCode;
    }

    public String getMainCode() {
        return this.mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather: [weatherIDCode: " + this.weatherIDCode + ", main: " + this.mainCode + ", description: " + this.description + ", icon: " + this.icon + "]";
    }

    
}
