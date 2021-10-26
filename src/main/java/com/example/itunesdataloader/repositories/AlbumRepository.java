package com.example.itunesdataloader.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.entities.Artist;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtist(Artist artist);

    List<Album> findByReleaseDateBetweenOrderByCollectionPriceAsc(LocalDateTime startDate, LocalDateTime endDate);

    List<Album> findByReleaseDateBetweenOrderByCollectionPriceDesc(LocalDateTime startDate, LocalDateTime endDate);
}
