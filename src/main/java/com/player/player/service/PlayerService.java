package com.player.player.service;

import com.player.player.dto.PlayerDto;
import com.player.player.mapper.PlayerDtoMapper;
import com.player.player.model.Player;
import com.player.player.repo.PlayerRepositry;
import com.player.player.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepositry playerRepositry;
    private final PlayerDtoMapper playerMapper;

    public Page<PlayerDto> getAllPlayers(Pageable pageable) {
        try{

            Page<Player> players = playerRepositry.findAll(pageable);
            return players.map(playerMapper::toDtoId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<PlayerDto> getById(String id) {
        try{

            return playerRepositry.findById(id)
                    .map(playerMapper::toDtoId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PlayerDto> findByDateOfBirthAfter(LocalDate date) {
        try{

            List<Player> players = playerRepositry.findByDateOfBirthAfter(date);
            return playerMapper.toDtoDateOfBirthAfter(players);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PlayerDto> findByDateOfBirthBetween(String startDate, String endDate) {
        try{

            List<Player> players = playerRepositry.findByDateOfBirthBetween(
                    DateUtils.dateConverter(startDate),
                    DateUtils.dateConverter(endDate)
            );
            return playerMapper.toDtoDateOfBirthBetween(players);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
