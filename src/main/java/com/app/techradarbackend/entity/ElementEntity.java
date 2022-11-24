package com.app.techradarbackend.entity;

import com.app.techradarbackend.enums.ElementStatus;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Element")
@Table(name = "element")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int elementId;
    private String elementName;
    private String elementDescription;
    @Enumerated(EnumType.STRING)
    private ElementStatus elementStatus;

    @ManyToOne
    @JoinColumn(name = "elementLevelId", referencedColumnName = "levelId")
    private LevelEntity levelEntity;

    @ManyToOne
    @JoinColumn(name = "elementRadarCategoryId", referencedColumnName = "radarCategoryId")
    private RadarCategoryEntity radarCategoryEntity;
}
