package com.example.itunesdataloader.dto;

import lombok.Data;

@Data
public class ArtistDTO {
    private Long artistId;
    private String artistName;
    private Long amgArtistId;
    private String wrapperType;
    private String artistType;
    private Long primaryGenreId;
    private String primaryGenreName;
}
