package com.example.itunesdataloader.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class OuterCommonDTO implements Serializable {
    private Integer resultCount;
    private List<InnerCommonDTO> results;
}
