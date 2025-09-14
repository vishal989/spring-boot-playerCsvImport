package com.player.player.config;

import com.player.player.service.CsvService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;

@Configuration
@RequiredArgsConstructor
public class DataLoaderConfig {
    private final CsvService csvService;

    @PostConstruct
    public void init() throws IOException {
        csvService.importCsv(Path.of("src", "main", "resources", "static", "Player.csv"));
    }
}
