package com.example.itunesdataloader.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

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
}
