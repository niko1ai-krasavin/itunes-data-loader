package com.example.itunesdataloader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.itunesdataloader.entities.Artist;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
