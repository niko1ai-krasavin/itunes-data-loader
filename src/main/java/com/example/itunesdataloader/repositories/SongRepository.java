package com.example.itunesdataloader.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itunesdataloader.entities.Song;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
