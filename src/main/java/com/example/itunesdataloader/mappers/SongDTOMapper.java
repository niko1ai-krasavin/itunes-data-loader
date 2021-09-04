package com.example.itunesdataloader.mappers;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;


@Component
public class SongDTOMapper {
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

    public SongDTO getSongDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setTrackId(song.getTrackId());
        songDTO.setTrackName(song.getTrackName());
        songDTO.setKind(song.getKind());
        songDTO.setReleaseDate(song.getReleaseDate());
        songDTO.setTrackNumber(song.getTrackNumber());
        songDTO.setTrackPrice(song.getTrackPrice());
        songDTO.setTrackTimeMillis(song.getTrackTimeMillis());
        songDTO.setCollectionId(song.getAlbum().getCollectionId());
        return songDTO;
    }
}
