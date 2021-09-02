package com.example.itunesdataloader.mappers;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.dto.InnerCommonDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MapperFromInnerCommonDTO {

    public ArtistDTO toArtistDTO(InnerCommonDTO innerCommonDTO) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistId(innerCommonDTO.getArtistId());
        artistDTO.setAmgArtistId(innerCommonDTO.getAmgArtistId());
        artistDTO.setArtistName(innerCommonDTO.getArtistName());
        artistDTO.setArtistType(innerCommonDTO.getArtistType());
        artistDTO.setPrimaryGenreId(innerCommonDTO.getPrimaryGenreId());
        artistDTO.setPrimaryGenreName(innerCommonDTO.getPrimaryGenreName());
        artistDTO.setWrapperType(innerCommonDTO.getWrapperType());
        return artistDTO;
    }

    public AlbumDTO toAlbumDTO(InnerCommonDTO innerCommonDTO) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setCollectionId(innerCommonDTO.getCollectionId());
        albumDTO.setCollectionName(innerCommonDTO.getCollectionName());
        albumDTO.setCollectionPrice(innerCommonDTO.getCollectionPrice());
        albumDTO.setCopyright(innerCommonDTO.getCopyright());
        albumDTO.setCountry(innerCommonDTO.getCountry());
        albumDTO.setCurrency(innerCommonDTO.getCurrency());
        albumDTO.setTrackCount(innerCommonDTO.getTrackCount());
        albumDTO.setCollectionType(innerCommonDTO.getCollectionType());
        albumDTO.setReleaseDate(LocalDateTime.parse(innerCommonDTO.getReleaseDate().strip(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        return albumDTO;
    }
}
