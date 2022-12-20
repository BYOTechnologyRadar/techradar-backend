package com.app.techradarbackend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryRadarUpdateDTO {
    @NotNull(message = "An ID must be provided for the radar. Please enter a valid ID and try again.")
    private Integer radarId;
}
