package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    private List<City> gameCities;

    // Empty Constructor
    public Game() {}

    
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
        return this.gameCities;
    }

    public void setGameCities(final List<City> gameCities) {
        this.gameCities = gameCities;
    }

    
    
}
