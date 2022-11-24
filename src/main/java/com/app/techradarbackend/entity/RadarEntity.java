package com.app.techradarbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Radar")
@Table(name = "radar")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RadarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int radarId;
    private String radarName;
    private String radarDescription;

    @OneToMany(mappedBy = "radarEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RadarCategoryEntity> radarCategoryEntityList;
}
