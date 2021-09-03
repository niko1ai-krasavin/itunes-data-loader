package com.example.itunesdataloader.mappers;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;


@Component
public class MapperFromSongDTO {
    public Song toSong(SongDTO songDTO) {
        Song song = new Song();
        song.setTrackId(songDTO.getTrackId());
        song.setTrackName(songDTO.getTrackName());
        song.setKind(songDTO.getKind());
        song.setReleaseDate(songDTO.getReleaseDate());
        song.setTrackNumber(songDTO.getTrackNumber());
        song.setTrackPrice(songDTO.getTrackPrice());
        song.setTrackTimeMillis(songDTO.getTrackTimeMillis());
        return song;
    }
}
