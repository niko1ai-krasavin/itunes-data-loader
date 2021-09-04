package com.example.itunesdataloader.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.repositories.SongRepository;
import com.example.itunesdataloader.mappers.SongDTOMapper;


@Data
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void saveSongs(List<Song> songs) {
        songRepository.saveAll(songs);
    }

    @Override
    public Song findSongById(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        return optionalSong.get();
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }
}
