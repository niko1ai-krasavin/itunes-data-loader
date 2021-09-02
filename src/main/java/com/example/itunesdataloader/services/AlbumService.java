package com.example.itunesdataloader.services;

import com.example.itunesdataloader.dto.AlbumDTO;

import java.util.List;

public interface AlbumService {
    void saveAlbum(AlbumDTO albumDTO);

    void saveAlbums(List<AlbumDTO> albumDTOs);
}
