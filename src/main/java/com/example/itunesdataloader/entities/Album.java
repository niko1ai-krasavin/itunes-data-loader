package com.example.itunesdataloader.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long collectionId;
    private String collectionType;
    private String collectionName;
    private Double collectionPrice;
    private Integer trackCount;
    private String copyright;
    private String country;
    private String currency;
    private LocalDateTime releaseDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId", nullable = false)
    private Artist artist;
    @Transient
    @OneToMany(mappedBy = "trackId", fetch = FetchType.LAZY)
    private Set<Song> songs = new HashSet<>();

    public Album(Long collectionId, String collectionType, String collectionName, Double collectionPrice,
                 Integer trackCount, String copyright, String country, String currency,
                 LocalDateTime releaseDate, Artist artist) {
        this.collectionId = collectionId;
        this.collectionType = collectionType;
        this.collectionName = collectionName;
        this.collectionPrice = collectionPrice;
        this.trackCount = trackCount;
        this.copyright = copyright;
        this.country = country;
        this.currency = currency;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }
}
