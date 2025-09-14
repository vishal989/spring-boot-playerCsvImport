package com.player.player.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerDto {
    private String playerID;
    private String nameFirst;
    private String nameLast;
    private Integer weight; // in pounds
    private Integer height; // in inches
    private String bats;
    private String throws_;
    private String debut;
    private String finalGame;
    private LocalDate dateOfBirth;
}
