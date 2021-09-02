package com.example.itunesdataloader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.repositories.AlbumRepository;


@Data
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public void saveAlbum(AlbumDTO albumDTO) {
        Album album = new Album();
        album.setCollectionId(albumDTO.getCollectionId());
        album.setCollectionName(albumDTO.getCollectionName());
        album.setCollectionPrice(albumDTO.getCollectionPrice());
        album.setCopyright(albumDTO.getCopyright());
        album.setCountry(albumDTO.getCountry());
        album.setCurrency(albumDTO.getCurrency());
        album.setTrackCount(albumDTO.getTrackCount());
        album.setCollectionType(albumDTO.getCollectionType());
        album.setReleaseDate(albumDTO.getReleaseDate());
        albumRepository.save(album);
    }

    @Override
    public void saveAlbums(List<AlbumDTO> albumDTOs) {
        List<Album> albums = new ArrayList<>();
        for (AlbumDTO item : albumDTOs) {
            Album album = new Album();
            album.setCollectionId(item.getCollectionId());
            album.setCollectionName(item.getCollectionName());
            album.setCollectionPrice(item.getCollectionPrice());
            album.setCopyright(item.getCopyright());
            album.setCountry(item.getCountry());
            album.setCurrency(item.getCurrency());
            album.setTrackCount(item.getTrackCount());
            album.setCollectionType(item.getCollectionType());
            album.setReleaseDate(item.getReleaseDate());
            albums.add(album);
        }
        albumRepository.saveAll(albums);
    }
}
