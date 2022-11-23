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
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;
    private String categoryLogo;
    private String categoryDescription;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<RadarCategoryEntity> radarCategoryEntityList;
}
