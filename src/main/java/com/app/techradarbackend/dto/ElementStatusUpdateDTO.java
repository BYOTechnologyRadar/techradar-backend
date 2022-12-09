package com.app.techradarbackend.dto;

import com.app.techradarbackend.enums.ElementStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ElementStatusUpdateDTO {
    @NotNull(message = "A status must be provided for the element. Please select a valid status and try again.")
    private ElementStatus status;
}
