package com.app.techradarbackend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RadarInfoDTO {
    private RadarDTO radarDTO;
    private Set<CategoryDTO> categorySet;
}
