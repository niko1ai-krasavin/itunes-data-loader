package com.example.itunesdataloader.services;

import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.entities.Artist;
import com.example.itunesdataloader.repositories.ArtistRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public void saveArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setArtistId(artistDTO.getArtistId());
        artist.setAmgArtistId(artistDTO.getAmgArtistId());
        artist.setArtistName(artistDTO.getArtistName());
        artist.setArtistType(artistDTO.getArtistType());
        artist.setPrimaryGenreId(artistDTO.getPrimaryGenreId());
        artist.setPrimaryGenreName(artistDTO.getPrimaryGenreName());
        artist.setWrapperType(artistDTO.getWrapperType());
        artistRepository.save(artist);
    }
}
