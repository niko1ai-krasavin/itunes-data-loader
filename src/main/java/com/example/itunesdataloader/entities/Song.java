package com.example.itunesdataloader.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long trackId;
    private String trackName;
    private String kind;
    private Double trackPrice;
    private LocalDateTime releaseDate;
    private Integer trackNumber;
    private Long trackTimeMillis;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collectionId", nullable = false)
    private Album album;
}
