package com.app.techradarbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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
    private List<RadarCategoryEntity> radarCategoryEntityList;
}
