package com.app.techradarbackend.dto;

import com.app.techradarbackend.enums.ElementLevel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ElementLevelUpdateDTO {
    @NotNull(message = "A level must be provided for the element. Please select a valid level and try again.")
    private ElementLevel level;
}
