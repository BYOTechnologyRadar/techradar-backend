package com.app.techradarbackend.converter;

import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.exception.ResourceNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class StatusConverter implements AttributeConverter<ElementStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ElementStatus status) {
        return status.getStatusId();
    }

    @Override
    public ElementStatus convertToEntityAttribute(Integer statusId) {
        return Arrays.stream(ElementStatus.values()).filter(status -> status.getStatusId().equals(statusId)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Element Status", "ID", statusId)
        );
    }
}
