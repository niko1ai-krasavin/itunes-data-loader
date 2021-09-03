package com.example.itunesdataloader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.repositories.SongRepository;
import com.example.itunesdataloader.mappers.MapperFromSongDTO;


@Data
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    private final MapperFromSongDTO mapperFromSongDTO;

    @Override
    public void saveSong(SongDTO songDTO) {
        songRepository.save(mapperFromSongDTO.toSong(songDTO));
    }

    @Override
    public void saveSongs(List<SongDTO> songDTOs) {
        List<Song> songs = new ArrayList<>();
        for (SongDTO item : songDTOs) {
            songs.add(mapperFromSongDTO.toSong(item));
        }
        songRepository.saveAll(songs);
    }
}
