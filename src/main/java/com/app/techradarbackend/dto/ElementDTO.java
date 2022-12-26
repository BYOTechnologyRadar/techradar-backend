package com.app.techradarbackend.dto;

import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import lombok.Data;

@Data
public class ElementDTO {
    private Integer id;
    private String name;
    private ElementLevel level;
    private ElementStatus status;
    private ElementVersion version;
}
