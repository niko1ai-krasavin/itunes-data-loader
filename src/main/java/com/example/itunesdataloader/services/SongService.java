package com.example.itunesdataloader.services;

import java.util.List;

import com.example.itunesdataloader.dto.SongDTO;


public interface SongService {

    void saveSong(SongDTO songDTO);

    void saveSongs(List<SongDTO> songDTOs);

}
