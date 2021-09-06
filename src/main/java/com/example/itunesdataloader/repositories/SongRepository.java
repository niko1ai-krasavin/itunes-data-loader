package com.example.itunesdataloader.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itunesdataloader.entities.Song;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByReleaseDateBetweenOrderByTrackPriceDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<Song> findByReleaseDateBetweenOrderByTrackPriceAsc(LocalDateTime startDate, LocalDateTime endDate);

}
