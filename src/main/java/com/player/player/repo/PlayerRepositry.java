package com.player.player.repo;

import com.player.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepositry extends JpaRepository<Player, String> {
}
