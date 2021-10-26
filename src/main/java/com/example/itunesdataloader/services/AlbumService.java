package com.example.itunesdataloader.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.itunesdataloader.entities.Album;


public interface AlbumService {

    void saveAlbum(Album album);

    void saveAlbums(List<Album> albums);

    Album findAlbumById(Long id);

    List<Album> findAllAlbums();

    List<Album> findAllByArtistId(Long artistId);

    List<Album> findAllAlbumsByYearAndSortedByCollectionPriceInAscOrDescOrder(LocalDateTime startDate,
                                                                        LocalDateTime endDate,
                                                                        String order);

}
