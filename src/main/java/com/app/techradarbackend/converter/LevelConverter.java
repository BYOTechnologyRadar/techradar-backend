package com.app.techradarbackend.converter;

import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.exception.ResourceNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class LevelConverter implements AttributeConverter<ElementLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ElementLevel level) {
        return level.getLevelId();
    }

    @Override
    public ElementLevel convertToEntityAttribute(Integer levelId) {
        return Arrays.stream(ElementLevel.values()).filter(level -> level.getLevelId() == levelId).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Element Level", "ID", levelId)
        );
    }
}
