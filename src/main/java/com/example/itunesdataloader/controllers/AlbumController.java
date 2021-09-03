package com.example.itunesdataloader.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.mappers.AlbumDTOMapper;
import com.example.itunesdataloader.services.AlbumService;


@AllArgsConstructor
@RestController
@RequestMapping("/app/albums")
public class AlbumController {

    @Autowired
    private final AlbumService albumService;

    @Autowired
    private final AlbumDTOMapper albumDTOMapper;


    @GetMapping()
    public List<AlbumDTO> getAllAlbums() {
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (Album item : albumService.findAllAlbums()) {
            albumDTOList.add(albumDTOMapper.getAlbumDTO(item));
        }
        return albumDTOList;
    }

    @GetMapping("/{id}")
    public AlbumDTO getAlbumById(@PathVariable Long id) {
        return albumDTOMapper.getAlbumDTO(albumService.findAlbumById(id));
    }
}
