package com.player.player.repo;

import com.player.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PlayerRepositry extends JpaRepository<Player, String> {
    List<Player> findByDateOfBirthAfter(LocalDate date);

    List<Player> findByDateOfBirthBetween(LocalDate start, LocalDate end);
}
