package com.player.player.mapper;

import com.player.player.model.Player;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;

public class PlayerMapper {

    public static Player fromCsvRecord(CSVRecord record) {
        Player player = new Player();

        player.setPlayerID(record.get("playerID"));

        String year = record.get("birthYear");
        String month = record.get("birthMonth");
        String day = record.get("birthDay");

        if (!year.isEmpty() && !month.isEmpty() && !day.isEmpty()) {
            player.setDateOfBirth(LocalDate.of(
                    Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(day)
            ));
        }

        player.setBirthCountry(record.get("birthCountry"));
        player.setBirthState(record.get("birthState"));
        player.setBirthCity(record.get("birthCity"));

        player.setDeathYear(parseInt(record.get("deathYear")));
        player.setDeathMonth(parseInt(record.get("deathMonth")));
        player.setDeathDay(parseInt(record.get("deathDay")));

        player.setDeathCountry(record.get("deathCountry"));
        player.setDeathState(record.get("deathState"));
        player.setDeathCity(record.get("deathCity"));

        player.setNameFirst(record.get("nameFirst"));
        player.setNameLast(record.get("nameLast"));
        player.setNameGiven(record.get("nameGiven"));

        player.setWeight(parseInt(record.get("weight")));
        player.setHeight(parseInt(record.get("height")));

        player.setBats(record.get("bats"));
        player.setThrows_(record.get("throws"));

        player.setDebut(record.get("debut"));
        player.setFinalGame(record.get("finalGame"));

        player.setRetroID(record.get("retroID"));
        player.setBbrefID(record.get("bbrefID"));

        return player;
    }

    private static Integer parseInt(String value) {
        try {
            return (value == null || value.isBlank()) ? null : Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
