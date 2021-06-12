package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "game_data")
public class GameData implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameDataId;

    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private Trainer relatedTrainer;

    //! Empty constructor
    public GameData() {}

    //! By ID constructor
    public GameData(int id) {
        this.gameDataId = id;
    }

    //! Getters and Setters
    public int getId() {
        return this.gameDataId;
    }

    public void setId(int id) {
        this.gameDataId  = id;
    }

    // public Trainer getRelatedTrainer() {
    //     return this.relatedTrainer;
    // }

    // public void setRelatedTrainer(Trainer relatedTrainer) {
    //     this.relatedTrainer = relatedTrainer;
    // }
}
