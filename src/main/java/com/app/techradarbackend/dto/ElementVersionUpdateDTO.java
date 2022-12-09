package com.app.techradarbackend.dto;

import com.app.techradarbackend.enums.ElementVersion;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ElementVersionUpdateDTO {
    @NotNull(message = "A version must be provided for the element. Please select a valid version and try again.")
    private ElementVersion version;
}
