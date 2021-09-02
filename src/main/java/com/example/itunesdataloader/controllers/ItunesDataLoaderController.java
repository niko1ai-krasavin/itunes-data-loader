package com.example.itunesdataloader.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import com.example.itunesdataloader.configurations.OkHttpConfiguration;
import com.example.itunesdataloader.dto.*;
import com.example.itunesdataloader.mappers.MapperFromInnerCommonDTO;
import com.example.itunesdataloader.services.AlbumService;
import com.example.itunesdataloader.services.ArtistService;
import com.example.itunesdataloader.services.SongService;


@AllArgsConstructor
@RestController
@RequestMapping("/itunes")
public class ItunesDataLoaderController {

    // private static String ARTIST_ID = "487143";  Artist => Pink Floyd

    private static String BASE_URL_ITUNES = "https://itunes.apple.com/lookup?";

    @Autowired
    private final OkHttpConfiguration okHttpConfiguration;

    @Autowired
    private final MapperFromInnerCommonDTO mapperFromInnerCommonDTO;

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final AlbumService albumService;

    @Autowired
    private final SongService songService;


    @GetMapping("/artist/{artistId}")
    public void getArtistFromITunes(@PathVariable Long artistId) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" + artistId).build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            ArtistDTO artistDTO = mapperFromInnerCommonDTO.toArtistDTO(outerCommonDTO.getResults().get(0));
            artistService.saveArtist(artistDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/artist/{artistId}/albums")
    public void getAlbumsFromITunes(@PathVariable Long artistId) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" +
                artistId + "&entity=album&limit=200").build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            ArtistDTO artistDTO = mapperFromInnerCommonDTO.toArtistDTO(outerCommonDTO.getResults().remove(0));
            List<AlbumDTO> albumDTOs = new ArrayList<>();
            for (InnerCommonDTO item : outerCommonDTO.getResults()) {
                albumDTOs.add(mapperFromInnerCommonDTO.toAlbumDTO(item));
            }
            artistService.saveArtist(artistDTO);
            albumService.saveAlbums(albumDTOs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/albums/{collectionId}/songs")
    public void getSongsFromITunes(@PathVariable Long collectionId) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" +
                collectionId + "&entity=song&limit=200").build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            AlbumDTO albumDTO = mapperFromInnerCommonDTO.toAlbumDTO(outerCommonDTO.getResults().remove(0));
            List<SongDTO> songDTOs = new ArrayList<>();
            for (InnerCommonDTO item : outerCommonDTO.getResults()) {
                songDTOs.add(mapperFromInnerCommonDTO.toSongDTO(item));
            }
            albumService.saveAlbum(albumDTO);
            songService.saveSongs(songDTOs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
