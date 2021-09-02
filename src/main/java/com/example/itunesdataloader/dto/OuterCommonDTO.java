package com.example.itunesdataloader.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class OuterCommonDTO implements Serializable {
    private Integer resultCount;
    private List<InnerCommonDTO> results;
}
