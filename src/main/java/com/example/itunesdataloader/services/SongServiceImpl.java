package com.example.itunesdataloader.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.itunesdataloader.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.repositories.SongRepository;


@Data
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    private final AlbumService albumService;

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

    @Override
    public List<Song> findAllByCollectionId(Long collectionId) {
        Album album = albumService.findAlbumById(collectionId);
        return songRepository.findByAlbum(album);
    }

    @Override
    public List<Song> findAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(LocalDateTime startDate,
                                                                              LocalDateTime endDate,
                                                                              String order) {
        String orderInLowerCase = order.toUpperCase();
        if (orderInLowerCase.equals("ASC")) {
            return songRepository.findByReleaseDateBetweenOrderByTrackPriceAsc(startDate, endDate);
        } else {
            return songRepository.findByReleaseDateBetweenOrderByTrackPriceDesc(startDate, endDate);
        }
    }
}
