package com.example.itunesdataloader.services;


import com.example.itunesdataloader.dto.SongDTO;

import java.util.List;

public interface SongService {
    void saveSong(SongDTO songDTO);

    void saveSongs(List<SongDTO> songDTOs);
}
