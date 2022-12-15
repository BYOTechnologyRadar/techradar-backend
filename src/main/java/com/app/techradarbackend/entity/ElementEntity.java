package com.app.techradarbackend.entity;

import com.app.techradarbackend.converter.LevelConverter;
import com.app.techradarbackend.converter.StatusConverter;
import com.app.techradarbackend.converter.VersionConverter;
import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "element")
public class ElementEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "version")
    @Convert(converter = VersionConverter.class)
    private ElementVersion version;

    @Column(name = "status")
    @Convert(converter = StatusConverter.class)
    private ElementStatus status;

    @Column(name = "level")
    @Convert(converter = LevelConverter.class)
    private ElementLevel level;
    @ManyToOne
    @JoinColumn(name = "ref_category")
    private CategoryEntity category;
}
