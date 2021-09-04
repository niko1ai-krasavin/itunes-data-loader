package com.example.itunesdataloader.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class SongDTO implements Serializable {
    private Long trackId;
    private String trackName;
    private String kind;
    private Double trackPrice;
    private LocalDateTime releaseDate;
    private Integer trackNumber;
    private Long trackTimeMillis;
    private Long collectionId;
}
