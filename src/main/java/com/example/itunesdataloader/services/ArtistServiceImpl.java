package com.example.itunesdataloader.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.entities.Artist;
import com.example.itunesdataloader.repositories.ArtistRepository;


@Data
@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public Artist findArtistById(Long id) {
        Optional<Artist> optionalArtist = artistRepository.findById(id);
        return optionalArtist.get();
    }

    @Override
    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }
}
