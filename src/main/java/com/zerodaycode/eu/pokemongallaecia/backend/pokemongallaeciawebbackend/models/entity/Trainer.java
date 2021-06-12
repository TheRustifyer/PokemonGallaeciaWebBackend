package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "trainers")
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // In game player name
    private String nickname;

    // The reverse relation with user
    @OneToOne(mappedBy = "trainer")
    private User relatedUser;

    // The relation with the different games that the trainer already started
    @OneToMany(mappedBy = "relatedTrainer")
    private List<GameData> relatedGameData;

    //! Empty constructor
    public Trainer() {}

    //! By ID constructor
    public Trainer(Integer trainerId) {
        this.id = trainerId;
    }

    //! Getters and Setters
    public int getId() {
        return this.id;
    }

    public void setId(int trainerId) {
        this.id = trainerId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User getRelatedUser() {
        return this.relatedUser;
    }

    public void setUser(User user) {
        this.relatedUser = user;
    }

    public List<GameData> getRelatedGameData() {
        return this.relatedGameData;
    }

    public void setRelatedGameData(List<GameData> gameData) {
        this.relatedGameData = gameData;
    }
}
