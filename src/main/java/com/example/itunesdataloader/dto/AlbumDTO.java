package com.example.itunesdataloader.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class AlbumDTO implements Serializable {
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
