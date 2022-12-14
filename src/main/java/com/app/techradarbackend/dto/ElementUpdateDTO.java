package com.app.techradarbackend.dto;

import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementUpdateDTO {
    @NotBlank
    @Size(min = 2, message = "The name provided for the element is too short. The name must have at least 2 characters. Please enter a longer name and try again.")
    private String name;

    @NotNull
    @NotBlank(message = "A description must be provided for the element. Please enter a valid description and try again.")
    private String description;

    @NotNull(message = "A status must be provided for the element. Please select a valid status and try again.")
    private ElementStatus status;

    @NotNull(message = "A level must be provided for the element. Please select a valid level and try again.")
    private ElementLevel level;

    @NotNull(message = "A version must be provided for the element. Please select a valid version and try again.")
    private ElementVersion version;

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
}
