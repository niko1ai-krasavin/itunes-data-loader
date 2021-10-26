package com.example.itunesdataloader.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.entities.Artist;
import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.mappers.ArtistDTOMapper;
import com.example.itunesdataloader.services.ArtistService;


@AllArgsConstructor
@Controller
@RequestMapping("/app/artists")
public class ArtistController {

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final ArtistDTOMapper artistDTOMapper;


    @GetMapping()
    public String getAllArtists(Model model) {
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        for (Artist item : artistService.findAllArtists()) {
            artistDTOList.add(artistDTOMapper.getArtistDTO(item));
        }
        model.addAttribute("artistResponse", artistDTOList);
        return "artists";
    }

    @GetMapping("/{id}")
    public String getArtistById(@PathVariable Long id, Model model) {
        ArtistDTO artistDTO = artistDTOMapper.getArtistDTO(artistService.findArtistById(id));
        model.addAttribute("artistResponse", artistDTO);
        return "artists";
    }

}
