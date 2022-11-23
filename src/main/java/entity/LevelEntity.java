package entity;

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
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int levelId;
    private String levelName;
    private String levelDescription;

    @OneToMany(mappedBy = "levelEntity", cascade = CascadeType.ALL)
    private List<ElementEntity> elementEntityList;
}

//techradar/api/category/