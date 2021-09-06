package com.example.itunesdataloader.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;


public interface SongService {

    void saveSong(Song song);

    void saveSongs(List<Song> songs);

    Song findSongById(Long id);

    List<Song> findAllSongs();

    List<Song> findAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(LocalDateTime startDate,
                                                                       LocalDateTime endDate,
                                                                       String order);
}
