package com.example.itunesdataloader.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

import com.example.itunesdataloader.entities.Album;
import com.example.itunesdataloader.entities.Artist;
import com.example.itunesdataloader.entities.Song;
import com.example.itunesdataloader.mappers.AlbumDTOMapper;
import com.example.itunesdataloader.mappers.ArtistDTOMapper;
import com.example.itunesdataloader.mappers.SongDTOMapper;
import com.example.itunesdataloader.configurations.OkHttpConfiguration;
import com.example.itunesdataloader.dto.*;
import com.example.itunesdataloader.mappers.InnerCommonDTOMapper;
import com.example.itunesdataloader.services.AlbumService;
import com.example.itunesdataloader.services.ArtistService;
import com.example.itunesdataloader.services.SongService;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@Controller
@RequestMapping("/dataloader")
public class ItunesDataLoaderController {

    // private static String ARTIST_ID = "487143";  Artist => Pink Floyd

    private static String BASE_URL_ITUNES = "https://itunes.apple.com/lookup?";

    @Autowired
    private final OkHttpConfiguration okHttpConfiguration;

    @Autowired
    private final InnerCommonDTOMapper innerCommonDTOMapper;

    @Autowired
    private final ArtistDTOMapper artistDTOMapper;

    @Autowired
    private final AlbumDTOMapper albumDTOMapper;

    @Autowired
    private final SongDTOMapper songDTOMapper;

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final AlbumService albumService;

    @Autowired
    private final SongService songService;


    @GetMapping()
    String viewDataloaderTemplate() {
        return "dataloader";
    }

    @GetMapping("/artist/{artistId}")
    public String getArtistFromITunes(@PathVariable Long artistId, Model model) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" + artistId).build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            ArtistDTO artistDTO = innerCommonDTOMapper.toArtistDTO(outerCommonDTO.getResults().get(0));
            artistService.saveArtist(artistDTOMapper.toArtist(artistDTO));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("dataLoaderResponse", "Data received successfully");
        return "dataloader";
    }

    // @GetMapping("/artist/{artistId}/albums")
    @GetMapping("/artist_and_albums")
    public String getAlbumsFromITunes(
            // @PathVariable Long artistId, Model model
            @RequestParam(value = "artistId", required = true) String artistId,
            Model model
    ) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" +
                artistId + "&entity=album&limit=200").build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            ArtistDTO artistDTO = innerCommonDTOMapper.toArtistDTO(outerCommonDTO.getResults().remove(0));
            List<AlbumDTO> albumDTOs = new ArrayList<>();
            for (InnerCommonDTO item : outerCommonDTO.getResults()) {
                albumDTOs.add(innerCommonDTOMapper.toAlbumDTO(item));
            }
            Artist artist = artistDTOMapper.toArtist(artistDTO);
            artistService.saveArtist(artist);
            List<Album> albums = new ArrayList<>();
            for (AlbumDTO item : albumDTOs) {
                Album album = albumDTOMapper.toAlbum(item);
                album.setArtist(artist);
                albums.add(album);
            }
            albumService.saveAlbums(albums);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("dataLoaderResponse", "Data received successfully");
        return "dataloader";
    }

    // @GetMapping("/albums/{collectionId}/songs")
    @GetMapping("/album_and_songs")
    public String getSongsFromITunes(
            // @PathVariable Long collectionId, Model model
            @RequestParam(value = "collectionId", required = true) String collectionId,
            Model model
    ) {

        OkHttpClient okHttpClient = okHttpConfiguration.okHttpClient();
        Request request = new Request.Builder().url(BASE_URL_ITUNES + "id=" +
                collectionId + "&entity=song&limit=200").build();

        Gson gson = new Gson();
        try {
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            OuterCommonDTO outerCommonDTO = gson.fromJson(responseBody.string(), OuterCommonDTO.class);
            AlbumDTO albumDTO = innerCommonDTOMapper.toAlbumDTO(outerCommonDTO.getResults().remove(0));
            Album album = albumDTOMapper.toAlbum(albumDTO);
            Artist artist = artistService.findArtistById(albumDTO.getArtistId());
            album.setArtist(artist);
            List<Song> songs = new ArrayList<>();
            for (InnerCommonDTO item : outerCommonDTO.getResults()) {
                SongDTO songDTO = innerCommonDTOMapper.toSongDTO(item);
                Song song = songDTOMapper.toSong(songDTO);
                song.setAlbum(album);
                songs.add(song);
            }
            albumService.saveAlbum(album);
            songService.saveSongs(songs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("dataLoaderResponse", "Data received successfully");
        return "dataloader";
    }
}
