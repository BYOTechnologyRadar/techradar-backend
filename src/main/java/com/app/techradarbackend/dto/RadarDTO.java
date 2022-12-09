package com.app.techradarbackend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RadarDTO {
    private Integer id;
    private String name;
    private String description;
    private Set<CategoryDTO> categorySet;
}
