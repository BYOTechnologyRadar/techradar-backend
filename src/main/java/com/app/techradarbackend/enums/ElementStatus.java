package com.app.techradarbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementStatus {
    INACTIVE(0),
    ACTIVE(1);
    private final Integer statusId;
}
