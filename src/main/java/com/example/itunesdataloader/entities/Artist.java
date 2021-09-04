package com.example.itunesdataloader.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long artistId;
    private String artistName;
    private Long amgArtistId;
    private String wrapperType;
    private String artistType;
    private Long primaryGenreId;
    private String primaryGenreName;
    @Transient
    @OneToMany(mappedBy = "collectionId", fetch = FetchType.LAZY)
    private Set<Album> albums = new HashSet<>();

    public Artist(Long artistId, String artistName, Long amgArtistId, String wrapperType,
                  String artistType,Long primaryGenreId, String primaryGenreName) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.amgArtistId = amgArtistId;
        this.wrapperType = wrapperType;
        this.artistType = artistType;
        this.primaryGenreId = primaryGenreId;
        this.primaryGenreName = primaryGenreName;
    }
}
