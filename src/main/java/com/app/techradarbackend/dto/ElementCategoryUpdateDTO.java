package com.app.techradarbackend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ElementCategoryUpdateDTO {
    @NotNull(message = "An ID must be provided for the category. Please enter a valid ID and try again.")
    private Integer categoryId;
}
