package com.player.player.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    private String playerID;   // primary key

    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;

    private String birthCountry;
    private String birthState;
    private String birthCity;

    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;

    private String deathCountry;
    private String deathState;
    private String deathCity;

    private String nameFirst;
    private String nameLast;
    private String nameGiven;

    private Integer weight; // in pounds
    private Integer height; // in inches

    private String bats;
    private String throws_;

    private String debut;
    private String finalGame;

    private String retroID;
    private String bbrefID;
}
