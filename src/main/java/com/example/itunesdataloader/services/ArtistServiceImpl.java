package com.example.itunesdataloader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.repositories.ArtistRepository;
import com.example.itunesdataloader.mappers.MapperFromArtistDTO;


@Data
@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    private final MapperFromArtistDTO mapperFromArtistDTO;

    @Override
    public void saveArtist(ArtistDTO artistDTO) {
        artistRepository.save(mapperFromArtistDTO.toArtist(artistDTO));
    }
}
