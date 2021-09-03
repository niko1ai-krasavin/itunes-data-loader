package com.example.itunesdataloader.mappers;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;


@Component
public class MapperFromAlbumDTO {
    public Album toAlbum(AlbumDTO albumDTO) {
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
        return album;
    }
}
