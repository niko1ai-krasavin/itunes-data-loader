package com.example.itunesdataloader.mappers;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;


@Component
public class AlbumDTOMapper {
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

    public AlbumDTO getAlbumDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setCollectionId(album.getCollectionId());
        albumDTO.setCollectionName(album.getCollectionName());
        albumDTO.setCollectionPrice(album.getCollectionPrice());
        albumDTO.setCopyright(album.getCopyright());
        albumDTO.setCountry(album.getCountry());
        albumDTO.setCurrency(album.getCurrency());
        albumDTO.setTrackCount(album.getTrackCount());
        albumDTO.setCollectionType(album.getCollectionType());
        albumDTO.setReleaseDate(album.getReleaseDate());
        albumDTO.setArtistId(album.getArtist().getArtistId());
        return albumDTO;
    }
}
