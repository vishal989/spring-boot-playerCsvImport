package com.player.player.service;

import com.player.player.dto.PlayerDto;
import com.player.player.model.Player;
import com.player.player.repo.PlayerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepositry playerRepositry;

    public List<Player> getAllPlayers() {
        try{
            return playerRepositry.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Player> getById(String id) {
        try{
            return playerRepositry.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
