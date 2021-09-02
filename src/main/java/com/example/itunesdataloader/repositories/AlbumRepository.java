package com.example.itunesdataloader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.itunesdataloader.entities.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
