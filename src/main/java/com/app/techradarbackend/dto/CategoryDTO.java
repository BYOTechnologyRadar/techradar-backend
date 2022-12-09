package com.app.techradarbackend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
    private RadarDTO radar;
    private Set<ElementDTO> elementSet;
}
