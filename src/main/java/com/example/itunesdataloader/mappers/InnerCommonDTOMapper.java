package com.example.itunesdataloader.mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.dto.InnerCommonDTO;
import com.example.itunesdataloader.dto.SongDTO;


@Component
public class InnerCommonDTOMapper {

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

    public SongDTO toSongDTO(InnerCommonDTO innerCommonDTO) {
        SongDTO songDTO = new SongDTO();
        songDTO.setTrackId(innerCommonDTO.getTrackId());
        songDTO.setTrackName(innerCommonDTO.getTrackName());
        songDTO.setKind(innerCommonDTO.getKind());
        songDTO.setReleaseDate(LocalDateTime.parse(innerCommonDTO.getReleaseDate().strip(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        songDTO.setTrackNumber(innerCommonDTO.getTrackNumber());
        songDTO.setTrackPrice(innerCommonDTO.getTrackPrice());
        songDTO.setTrackTimeMillis(innerCommonDTO.getTrackTimeMillis());
        return songDTO;
    }
}
