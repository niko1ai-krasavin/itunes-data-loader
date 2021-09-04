package com.example.itunesdataloader.services;

import com.example.itunesdataloader.entities.Album;

import java.util.List;


public interface AlbumService {

    void saveAlbum(Album album);

    void saveAlbums(List<Album> albums);

    Album findAlbumById(Long id);

    List<Album> findAllAlbums();

}
