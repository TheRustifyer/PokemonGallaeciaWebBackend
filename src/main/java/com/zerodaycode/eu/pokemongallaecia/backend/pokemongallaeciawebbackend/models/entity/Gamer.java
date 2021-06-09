package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "gamers")
public class Gamer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gamerId;
    
    // In game player name
    private String nickname;

    // The reverse relation with user
    @OneToOne(mappedBy = "relatedGamer")
    private User relatedUser;

    // The relation with the different games that the gamer already started
    @OneToMany(mappedBy = "relatedGamer")
    private List<GameData> relatedGameData;

    //! Empty constructor
    public Gamer() {}

    //! By ID constructor
    public Gamer(Integer id) {
        this.gamerId = id;
    }

    //! Getters and Setters
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // public User getRelatedUser() {
    //     return this.relatedUser;
    // }

    // public void setUser(User user) {
    //     this.relatedUser = user;
    // }

    public List<GameData> getRelatedGameData() {
        return this.relatedGameData;
    }

    public void setRelatedGameData(List<GameData> gameData) {
        this.relatedGameData = gameData;
    }
}
