package com.example.itunesdataloader.services;

import java.util.List;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;


public interface SongService {

    void saveSong(SongDTO songDTO);

    void saveSongs(List<SongDTO> songDTOs);

    Song findSongById(Long id);

    List<Song> findAllSongs();

}
