package com.player.player.service;

import com.player.player.mapper.PlayerMapper;
import com.player.player.model.Player;
import com.player.player.repo.PlayerRepositry;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class CsvService {

    private final PlayerRepositry playerRepository;

    public void importCsv(Path path) throws IOException{
        try (
                Reader reader = Files.newBufferedReader(path);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (var record : csvParser) {
                Player player = PlayerMapper.fromCsvRecord(record);
                playerRepository.save(player);
            }
        }
    }

}
