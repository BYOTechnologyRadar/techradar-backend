package com.app.techradarbackend.converter;

import com.app.techradarbackend.enums.ElementVersion;
import com.app.techradarbackend.exception.ResourceNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class VersionConverter implements AttributeConverter<ElementVersion, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ElementVersion version) {
        return version.getVersionId();
    }

    @Override
    public ElementVersion convertToEntityAttribute(Integer versionId) {
        return Arrays.stream(ElementVersion.values()).filter(version -> version.getVersionId().equals(versionId)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Element Version", "ID", versionId)
        );
    }
}
