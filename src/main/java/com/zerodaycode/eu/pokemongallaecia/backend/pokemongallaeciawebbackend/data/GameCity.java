package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data;

import java.util.Arrays;
import java.util.List;

public enum GameCity {
    // The most secret place on the game ;)
    CAMPO_DE_PRUEBAS(Province.A_CORUÑA, false),
    // Cities on A Coruña province
    PUEBLO_DE_TEO(Province.LUGO, false),
    SANTIAGO_DE_COMPOSTELA(Province.A_CORUÑA, true),
    A_CORUÑA(Province.A_CORUÑA, true),
    AMES(Province.A_CORUÑA, true);

    private Province province;
    private Boolean weatherOnOpenweather;

    GameCity(Province province, Boolean weatherOnOpenweather) {
        this.province = province;
        this.weatherOnOpenweather = weatherOnOpenweather;
    }

    public Boolean hasAvailiableWeatherRequest() {
        if (this.weatherOnOpenweather) {
            return true;
        } else { return false ;}
    }

    public Province getCityProvince() {
        return this.province;
    }

    @Override
    public String toString() {
        // Initializes a variable to store the final formatted name
        StringBuilder cityName = new StringBuilder();

        // Stores which words should not be capitalized
        List<String> notCapitalize = Arrays.asList("de");

        String[] enumNameWords = super.toString().split("_");

        for (int i = 0; i < enumNameWords.length; i++) {
            String word = enumNameWords[i];
            String lowercaseWord = word.toLowerCase();
            
            if (!notCapitalize.contains(lowercaseWord)) {
                String firstLetter = lowercaseWord.substring(0, 1);
                String remainingChars = lowercaseWord.substring(1, lowercaseWord.length());
                cityName.append(firstLetter.toUpperCase() + remainingChars);
            } else {
                cityName.append(lowercaseWord);
            }

            if (i < enumNameWords.length - 1) {
                cityName.append(" ");
            }
        }
        
        return cityName.toString();
    }

    /// Converts the enum's constant identifier to a url param format
    public String toUrl() {
        // Initializes a variable to store the final formatted url
        StringBuilder cityUrl = new StringBuilder();

        String[] enumNameWords = super.toString().split("_");

        for (int i = 0; i < enumNameWords.length; i++) {
            cityUrl.append(enumNameWords[i].toLowerCase());

            if (i < enumNameWords.length - 1) {
                cityUrl.append("%20");
            }
        }
        
        return cityUrl.toString();
    }
}
