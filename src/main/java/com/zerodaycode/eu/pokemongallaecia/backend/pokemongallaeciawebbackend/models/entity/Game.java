package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import javax.persistence.*;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data.Data;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.CityRepository;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils.OpenWeatherInformation;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/*
Game class is basically designed to offer real data to the Game throught this REST API,
like the correct today's date, check if the internal game clock has been pwned comparing with this API data,
real-time weather information in all game cities availiables...

It's also designed in a self-managed way. This class makes multiple static calls initilializing internal Game data that should this API 
serve. At start, make external API calls to another websites to retrive every game city current's weather, for example.

*/

@Entity
@Table(name = "game")
public class Game implements Serializable {
    
    private static final String gameName = "Pokémon Gallaecia";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(referencedColumnName = "id")
    @OneToMany
    private static List<City> gameCities;

    private static String lastDataUpdate;
    
    private static String todaysDate;

    private static Integer sunriseHour;
    private static Integer sunsetHour;

    // Constructor
    public Game() throws Exception {
        Game.gameCities = CityRepository.loadGameCities();
        Game.retrieveTodaysDate(); 
        Game.gameSunriseSunsetHour();
    }

    private static void gameSunriseSunsetHour() throws Exception {
        OpenWeatherInformation owi = new OpenWeatherInformation();
        HashMap<String, Integer> myDayTime = owi.getSunriseSunsetHour();
        Game.sunriseHour = myDayTime.get("sunrise");
        Game.sunsetHour = myDayTime.get("sunset");
    }

    private static void dataUpdateTimestamp() {
        GregorianCalendar gregCalendar = new GregorianCalendar();
        
        int hour = gregCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = gregCalendar.get(Calendar.MINUTE);
        int seconds = gregCalendar.get(Calendar.SECOND);

        Game.lastDataUpdate = Integer.toString(hour) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
    }

    private static void retrieveTodaysDate() {
        GregorianCalendar gregCalendar = new GregorianCalendar();
        
        int dow = gregCalendar.get(Calendar.DAY_OF_WEEK);
        String dayOfTheWeek = (dow > 1) ? Data.DAYS_OF_THE_WEEK[dow - 2] : Data.DAYS_OF_THE_WEEK[Data.DAYS_OF_THE_WEEK.length - 1];
        
        int day = gregCalendar.get(Calendar.DATE);
        
        String month = Data.MONTHS[gregCalendar.get(Calendar.MONTH)]; 
        
        int year = gregCalendar.get(Calendar.YEAR);  

        Game.todaysDate = dayOfTheWeek + ", " + day + " " + month + " " + year;
        Game.dataUpdateTimestamp();
    }

    // Getters and setters
    public String getGameName() {
        return Game.gameName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public List<City> getGameCities() {
        return Game.gameCities;
    }

    public void setGameCities(List<City> gameCities) {
        Game.gameCities = gameCities;
    }

    public String getLastDataUpdate() {
        return Game.lastDataUpdate;
    }

    public void setLastDataUpdate(String lastDataUpdate) {
        Game.lastDataUpdate = lastDataUpdate;
    }

    public String getTodaysDate() {
        return Game.todaysDate;
    }

    public void setTodaysDate(String todaysDate) {
        Game.todaysDate = todaysDate;
    }

    public Integer getSunriseHour() {
        return Game.sunriseHour;
    }

    public void setSunriseHour(Integer sunriseHour) {
        Game.sunriseHour = sunriseHour;
    }

    public Integer getSunsetHour() {
        return Game.sunsetHour;
    }

    public void setSunsetHour(Integer sunsetHour) {
        Game.sunsetHour = sunsetHour;
    }

    @Override
    public String toString() {
        return "Game [ID=" + this.id + ", gameCities=" + Game.gameCities + "]";
    }
}
