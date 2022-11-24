package com.app.techradarbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Level")
@Table(name = "level")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int levelId;
    private String levelName;
    private String levelDescription;

    @OneToMany(mappedBy = "levelEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ElementEntity> elementEntityList;
}

//techradar/api/category/