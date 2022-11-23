package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
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

    @ManyToOne
    @JoinColumn(name = "levelId", referencedColumnName = "levelId")
    private LevelEntity levelEntity;

    @ManyToOne
    @JoinColumn(name = "radarCategoryId", referencedColumnName = "radarCategoryId")
    private RadarCategoryEntity radarCategoryEntity;
}
