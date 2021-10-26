package com.example.itunesdataloader.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.itunesdataloader.entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.repositories.AlbumRepository;


@Data
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    private final ArtistService artistService;

    @Override
    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void saveAlbums(List<Album> albums) {
        albumRepository.saveAll(albums);
    }

    @Override
    public Album findAlbumById(Long id) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        return optionalAlbum.get();
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> findAllByArtistId(Long artistId) {
        Artist artist = artistService.findArtistById(artistId);
        return albumRepository.findByArtist(artist);
    }

    @Override
    public List<Album> findAllAlbumsByYearAndSortedByCollectionPriceInAscOrDescOrder(LocalDateTime startDate, LocalDateTime endDate, String order) {
        String orderInLowerCase = order.toUpperCase();
        if (orderInLowerCase.equals("ASC")) {
            return albumRepository.findByReleaseDateBetweenOrderByCollectionPriceAsc(startDate, endDate);
        } else {
            return albumRepository.findByReleaseDateBetweenOrderByCollectionPriceDesc(startDate, endDate);
        }
    }

}
