package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RadarCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int radarCategoryId;

    @ManyToOne
    @JoinColumn(name = "radarId", referencedColumnName = "radarId")
    private RadarEntity radarEntity;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private CategoryEntity categoryEntity;
}
