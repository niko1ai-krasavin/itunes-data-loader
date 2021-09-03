package com.example.itunesdataloader.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.entities.Artist;
import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.mappers.ArtistDTOMapper;
import com.example.itunesdataloader.services.ArtistService;


@AllArgsConstructor
@RestController
@RequestMapping("/app/artists")
public class ArtistController {

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final ArtistDTOMapper artistDTOMapper;


    @GetMapping()
    public List<ArtistDTO> getAllArtists() {
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        for (Artist item : artistService.findAllArtists()) {
            artistDTOList.add(artistDTOMapper.getArtistDTO(item));
        }
        return artistDTOList;
    }

    @GetMapping("/{id}")
    public ArtistDTO getArtistById(@PathVariable Long id) {
        return artistDTOMapper.getArtistDTO(artistService.findArtistById(id));
    }

}
