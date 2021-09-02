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

}
