package com.app.techradarbackend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategorySearchDTO {
    @NotBlank
    @Size(min = 2, message = "The name provided for the category is too short. The name must have at least 2 characters. Please enter a longer name and try again.")
    private String name;

    public void setName(String name) {
        this.name = name.trim();
    }
}
