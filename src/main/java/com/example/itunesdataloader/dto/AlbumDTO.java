package com.example.itunesdataloader.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlbumDTO {
    private Long collectionId;
    private String collectionType;
    private String collectionName;
    private Double collectionPrice;
    private Integer trackCount;
    private String copyright;
    private String country;
    private String currency;
    private LocalDateTime releaseDate;
}
