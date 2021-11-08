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

import com.example.itunesdataloader.dto.SongDTO;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.mappers.SongDTOMapper;
import com.example.itunesdataloader.services.SongService;


@AllArgsConstructor
@Controller
@RequestMapping("/app/songs")
public class SongController {

    @Autowired
    private final SongService songService;

    @Autowired
    private final SongDTOMapper songDTOMapper;

    @Autowired
    private final ItunesDataLoaderController itunesDataLoaderController;

    @GetMapping()
    public String getAllSongs(Model model) {
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song item : songService.findAllSongs()) {
            songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        model.addAttribute("songResponse",  songDTOList);
        return "songs";
    }

    @GetMapping("/{id}")
    public String getSongById(@PathVariable Long id, Model model) {
        model.addAttribute("songResponse",  songDTOMapper.getSongDTO(songService.findSongById(id)));
        return "songs";
    }

    @GetMapping("/find/{collectionId}")
    public String getAllSongsByCollectionId(@PathVariable Long collectionId, Model model) {
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song item : songService.findAllByCollectionId(collectionId)) {
            songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        if (songDTOList.size() == 0) {
            itunesDataLoaderController.getSongsFromITunes(collectionId.toString(), model);
            for (Song item : songService.findAllByCollectionId(collectionId))
                songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        model.addAttribute("songResponse", songDTOList);
        return "songs";
    }

    @GetMapping("/lookup")
    public String getAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(
            @RequestParam(value = "year", required = true) String year,
            @RequestParam(value = "order", required = true) String order,
            Model model
    ) {
        String strStartDate = year + "-01-01T00:00:00Z";
        String strEndDate = year + "-12-31T23:59:59Z";
        LocalDateTime startDate = LocalDateTime.parse(strStartDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime endDate = LocalDateTime.parse(strEndDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song item : songService.findAllSongsByYearAndSortedByTrackPriceInAscOrDescOrder(startDate, endDate, order)) {
            songDTOList.add(songDTOMapper.getSongDTO(item));
        }
        model.addAttribute("songResponse",  songDTOList);
        return "songs";
    }
}
