package com.example.itunesdataloader.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
