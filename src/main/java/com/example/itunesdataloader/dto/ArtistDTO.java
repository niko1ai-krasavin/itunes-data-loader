package com.example.itunesdataloader.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ArtistDTO implements Serializable {
    private Long artistId;
    private String artistName;
    private Long amgArtistId;
    private String wrapperType;
    private String artistType;
    private Long primaryGenreId;
    private String primaryGenreName;
}
