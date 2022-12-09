package com.app.techradarbackend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RadarCreateAndUpdateDTO {
    @NotBlank
    @Size(min = 2, message = "The name provided for the radar is too short. The name must have at least 2 characters. Please enter a longer name and try again.")
    private String name;

    @NotBlank(message = "A description must be provided for the radar. Please enter a valid description and try again.")
    private String description;

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
}
