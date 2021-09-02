package com.example.itunesdataloader.controllers;

import com.example.itunesdataloader.configurations.OkHttpConfiguration;
import com.example.itunesdataloader.dto.AlbumDTO;
import com.example.itunesdataloader.dto.ArtistDTO;
import com.example.itunesdataloader.dto.InnerCommonDTO;
import com.example.itunesdataloader.dto.OuterCommonDTO;
import com.example.itunesdataloader.mappers.MapperFromInnerCommonDTO;
import com.example.itunesdataloader.services.AlbumService;
import com.example.itunesdataloader.services.ArtistService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/itunes")
public class ItunesDataLoaderController {

    private static String BASE_URL_ITUNES = "https://itunes.apple.com/lookup?";
    private static String ARTIST_ID = "487143";

    @Autowired
    private final OkHttpConfiguration okHttpConfiguration;

    @Autowired
    private final MapperFromInnerCommonDTO mapperFromInnerCommonDTO;

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final AlbumService albumService;


    @GetMapping(path="/albums", produces="application/json")
    public void getAlbumsFromITunes() {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" +
                ARTIST_ID + "&entity=album&limit=200").build();

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
}
