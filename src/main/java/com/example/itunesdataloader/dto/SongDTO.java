package com.example.itunesdataloader.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SongDTO {
    private Long trackId;
    private String trackName;
    private String kind;
    private Double trackPrice;
    private LocalDateTime releaseDate;
    private Integer trackNumber;
    private Long trackTimeMillis;
}
