package com.example.itunesdataloader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.repositories.SongRepository;


@Data
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public void saveSong(SongDTO songDTO) {
        Song song = new Song();
        songDTO.setTrackId(songDTO.getTrackId());
        songDTO.setTrackName(songDTO.getTrackName());
        songDTO.setKind(songDTO.getKind());
        songDTO.setReleaseDate(songDTO.getReleaseDate());
        songDTO.setTrackNumber(songDTO.getTrackNumber());
        songDTO.setTrackPrice(songDTO.getTrackPrice());
        songDTO.setTrackTimeMillis(songDTO.getTrackTimeMillis());
        songRepository.save(song);
    }

    @Override
    public void saveSongs(List<SongDTO> songDTOs) {
        List<Song> songs = new ArrayList<>();
        for (SongDTO item : songDTOs) {
            Song song = new Song();
            song.setTrackId(item.getTrackId());
            song.setTrackName(item.getTrackName());
            song.setKind(item.getKind());
            song.setReleaseDate(item.getReleaseDate());
            song.setTrackNumber(item.getTrackNumber());
            song.setTrackPrice(item.getTrackPrice());
            song.setTrackTimeMillis(item.getTrackTimeMillis());
            songs.add(song);
        }
        songRepository.saveAll(songs);
    }
}
