package com.example.itunesdataloader.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.repositories.AlbumRepository;


@Data
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void saveAlbums(List<Album> albums) {
        albumRepository.saveAll(albums);
    }

    @Override
    public Album findAlbumById(Long id) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        return optionalAlbum.get();
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }
}
