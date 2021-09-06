package com.example.itunesdataloader.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.mappers.SongDTOMapper;
import com.example.itunesdataloader.services.SongService;


@AllArgsConstructor
@RestController
@RequestMapping("/app/songs")
public class SongController {

    @Autowired
    private final SongService songService;

    @Autowired
    private final SongDTOMapper songDTOMapper;

    @GetMapping()
    public List<SongDTO> getAllSongs() {
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song item : songService.findAllSongs()) {
            songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        return songDTOList;
    }

    @GetMapping("/{id}")
    public SongDTO getSongById(@PathVariable Long id) {
        return songDTOMapper.getSongDTO(songService.findSongById(id));
    }

    @GetMapping("/lookup")
    public List<SongDTO> getAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(
            @RequestParam String year,
            @RequestParam String order
    ) {
        String strStartDate = year + "-01-01T00:00:00Z";
        String strEndDate = year + "-12-31T23:59:59Z";
        LocalDateTime startDate = LocalDateTime.parse(strStartDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime endDate = LocalDateTime.parse(strEndDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song item : songService.findAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(startDate, endDate, order)) {
            songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        return songDTOList;
    }
}
