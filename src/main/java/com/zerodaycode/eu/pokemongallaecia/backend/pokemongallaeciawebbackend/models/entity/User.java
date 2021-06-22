package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Account data
    @NotEmpty
    @Size(min = 4, max = 25)
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    // User "real life" data
    private String name;

    @Column(name = "last_name")
    private String lastName;
    
    // Account details
    @Column(name = "account_creation_date")
    @Temporal(TemporalType.DATE)
    private Date accountCreationDate;

    @PrePersist
    public void prePersist() {
        this.accountCreationDate = new Date();
    }

    // The relation with the trainer table
    @JoinColumn(referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Trainer trainer;

    // Empty constructor (Java Beans requisite)
    public User() {}

    // By ID constructor
    public User(Integer id) {
        this.id = id;
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Trainer gettrainer() {
        return trainer;
    }

    public void settrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "User [accountCreationDate=" + accountCreationDate + ", email=" + email + ", trainer=" + trainer + ", id="
                + id + ", lastName=" + lastName + ", name=" + name + ", password=" + password + ", username=" + username
                + "]";
    }


    

}
