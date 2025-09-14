package com.player.player.mapper;

import com.player.player.dto.PlayerDto;
import com.player.player.model.Player;
import org.springframework.data.domain.Page;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {
    PlayerDto toDtoId(Player player);
    List<PlayerDto> toDtoDateOfBirthAfter(List<Player> player);
    List<PlayerDto> toDtoDateOfBirthBetween(List<Player> player);
}
