package com.example.itunesdataloader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.repositories.AlbumRepository;
import com.example.itunesdataloader.mappers.MapperFromAlbumDTO;


@Data
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    private final MapperFromAlbumDTO mapperFromAlbumDTO;

    @Override
    public void saveAlbum(AlbumDTO albumDTO) {
        albumRepository.save(mapperFromAlbumDTO.toAlbum(albumDTO));
    }

    @Override
    public void saveAlbums(List<AlbumDTO> albumDTOs) {
        List<Album> albums = new ArrayList<>();
        for (AlbumDTO item : albumDTOs) {
            albums.add(mapperFromAlbumDTO.toAlbum(item));
        }
        albumRepository.saveAll(albums);
    }
}
