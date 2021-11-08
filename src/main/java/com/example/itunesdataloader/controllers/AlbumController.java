package com.example.itunesdataloader.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.mappers.AlbumDTOMapper;
import com.example.itunesdataloader.services.AlbumService;


@AllArgsConstructor
@Controller
@RequestMapping("/app/albums")
public class AlbumController {

    @Autowired
    private final AlbumService albumService;

    @Autowired
    private final AlbumDTOMapper albumDTOMapper;

    @Autowired
    private final ItunesDataLoaderController itunesDataLoaderController;

    @GetMapping()
    public String getAllAlbums(Model model) {
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (Album item : albumService.findAllAlbums()) {
            albumDTOList.add(albumDTOMapper.getAlbumDTO(item));
        }
        model.addAttribute("albumResponse", albumDTOList);
        return "albums";
    }

    @GetMapping("/{id}")
    public String getAlbumById(@PathVariable Long id, Model model) {
        model.addAttribute("albumResponse", albumDTOMapper.getAlbumDTO(albumService.findAlbumById(id)));
        return "albums";
    }

    @GetMapping("/find/{artistId}")
    public String getAllAlbumsByArtistId(@PathVariable Long artistId, Model model) {
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (Album item : albumService.findAllByArtistId(artistId)) {
            albumDTOList.add(albumDTOMapper.getAlbumDTO(item));
        }
        if (albumDTOList.size() == 0) {
            itunesDataLoaderController.getSongsFromITunes(artistId.toString(), model);
            for (Album item : albumService.findAllByArtistId(artistId))
                albumDTOList.add(albumDTOMapper.getAlbumDTO(item));
        }
        model.addAttribute("albumResponse", albumDTOList);
        return "albums";
    }

    @GetMapping("/lookup")
    public String getAllAlbumsByYearAndSortedByCollectionPriceInAscOrDescOrder(
            @RequestParam(value = "year", required = true) String year,
            @RequestParam(value = "order", required = true) String order,
            Model model
    ) {
        String strStartDate = year + "-01-01T00:00:00Z";
        String strEndDate = year + "-12-31T23:59:59Z";
        LocalDateTime startDate = LocalDateTime.parse(strStartDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime endDate = LocalDateTime.parse(strEndDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (Album item : albumService.findAllAlbumsByYearAndSortedByCollectionPriceInAscOrDescOrder(startDate, endDate, order)) {
            albumDTOList.add(albumDTOMapper.getAlbumDTO(item));
        }
        model.addAttribute("albumResponse",  albumDTOList);
        return "albums";
    }
}
