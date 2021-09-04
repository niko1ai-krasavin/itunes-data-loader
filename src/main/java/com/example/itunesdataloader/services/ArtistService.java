package com.example.itunesdataloader.services;

import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.entities.Artist;

import java.util.List;


public interface ArtistService {

    void saveArtist(Artist artist);

    Artist findArtistById(Long id);

    List<Artist> findAllArtists();

}
