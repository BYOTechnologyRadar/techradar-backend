package com.app.techradarbackend.dto;

import lombok.Data;

@Data
public class ElementInfoDTO {
    private ElementDTO elementDTO;
    private String description;
    private Integer categoryId;
}
