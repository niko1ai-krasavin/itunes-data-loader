package com.example.itunesdataloader.mappers;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.entities.Artist;


@Component
public class MapperFromArtistDTO {
    public Artist toArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setArtistId(artistDTO.getArtistId());
        artist.setAmgArtistId(artistDTO.getAmgArtistId());
        artist.setArtistName(artistDTO.getArtistName());
        artist.setArtistType(artistDTO.getArtistType());
        artist.setPrimaryGenreId(artistDTO.getPrimaryGenreId());
        artist.setPrimaryGenreName(artistDTO.getPrimaryGenreName());
        artist.setWrapperType(artistDTO.getWrapperType());
        return artist;
    }
}
