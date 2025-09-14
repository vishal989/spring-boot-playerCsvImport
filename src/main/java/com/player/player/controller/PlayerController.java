package com.player.player.controller;

import com.player.player.dto.PlayerDto;
import com.player.player.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Operation
    @GetMapping("/")
    public ResponseEntity<Page<PlayerDto>> getAllPlayers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PlayerDto> response = playerService.getAllPlayers(pageable);
        return response.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getById(@PathVariable String id) {
        Optional<PlayerDto> response = playerService.getById(id);

        if(response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }

    @Operation
    @GetMapping("/findDob")
    public ResponseEntity<List<PlayerDto>> findByDateOfBirthBetween(@RequestParam String startDate, @RequestParam String endDate) {
        List<PlayerDto> response = playerService.findByDateOfBirthBetween(startDate, endDate);

        if(response.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
