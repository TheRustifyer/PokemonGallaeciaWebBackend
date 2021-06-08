package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "game_data")
public class GameData implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private short gameDataId;

    @OneToOne(mappedBy = "relatedGameData")
    private Gamer related_gamer;

    //! Empty constructor
    public GameData() {}

    //! By ID constructor
    public GameData(short id) {
        this.gameDataId = id;
    }

    //! Getters and Setters
    public short getId() {
        return this.gameDataId;
    }

    public void setId(short id) {
        this.gameDataId  = id;
    }
}
