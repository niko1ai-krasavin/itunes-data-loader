package com.example.itunesdataloader.services;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;

import java.util.List;


public interface AlbumService {

    void saveAlbum(AlbumDTO albumDTO);

    void saveAlbums(List<AlbumDTO> albumDTOs);

    Album findAlbumById(Long id);

    List<Album> findAllAlbums();

}
