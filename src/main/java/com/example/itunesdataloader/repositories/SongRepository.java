package com.example.itunesdataloader.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.entities.Song;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByAlbum(Album album);

    List<Song> findByReleaseDateBetweenOrderByTrackPriceDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<Song> findByReleaseDateBetweenOrderByTrackPriceAsc(LocalDateTime startDate, LocalDateTime endDate);

}
