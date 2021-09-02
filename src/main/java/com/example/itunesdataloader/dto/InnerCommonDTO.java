package com.example.itunesdataloader.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class InnerCommonDTO implements Serializable {
    private String wrapperType;
    private String artistType;
    private String artistName;
    private String artistLinkUrl;
    private Long artistId;
    private Long amgArtistId;
    private String primaryGenreName;
    private Long primaryGenreId;
    private String collectionType;
    private Long collectionId;
    private String collectionName;
    private String collectionCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String artworkUrl60;
    private String artworkUrl100;
    private Double collectionPrice;
    private String collectionExplicitness;
    private Integer trackCount;
    private String copyright;
    private String country;
    private String currency;
    private String releaseDate;
    private String kind;
    private Long trackId;
    private String trackName;
    private String trackCensoredName;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private Double trackPrice;
    private String trackExplicitness;
    private Integer discCount;
    private Integer discNumber;
    private Integer trackNumber;
    private Long trackTimeMillis;
    private Boolean isStreamable;
}
