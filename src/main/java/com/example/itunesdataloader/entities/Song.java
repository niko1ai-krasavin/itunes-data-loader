package com.example.itunesdataloader.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

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

}
