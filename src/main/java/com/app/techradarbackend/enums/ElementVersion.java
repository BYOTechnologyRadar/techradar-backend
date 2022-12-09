package com.app.techradarbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementVersion {
    New(1, "New in this version"),
    Changed(2, "Recently changed"),
    Unchanged(3, "Unchanged");

    private final Integer versionId;
    private final String versionDescription;
}
