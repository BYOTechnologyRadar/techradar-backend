package com.app.techradarbackend.dataProvider;

import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.RadarEntity;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CategoryDataProvider {
    private static CategoryEntity createCategoryEntity() {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);
        categoryEntity.setName("Languages & Frameworks");
        categoryEntity.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");
        categoryEntity.setRadar(new RadarEntity());
        categoryEntity.setElementSet(new HashSet<>());

        return categoryEntity;
    }

    private static CategoryDTO createCategoryDTO() {
        final CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1);
        categoryDTO.setName("Languages & Frameworks");
        categoryDTO.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");

        return categoryDTO;
    }

    private static CategoryCreateAndUpdateDTO createCategoryCreateAndUpdateDTO() {
        final CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO = new CategoryCreateAndUpdateDTO();
        categoryCreateAndUpdateDTO.setName("Languages & Frameworks");
        categoryCreateAndUpdateDTO.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");

        return categoryCreateAndUpdateDTO;
    }

    @DataProvider
    public Object[][] getCategoryCreateAndUpdateDTOAndCategoryEntityAndCategoryDTO() {
        final CategoryCreateAndUpdateDTO categoryCreateDTO = createCategoryCreateAndUpdateDTO();
        final CategoryEntity categoryEntity = createCategoryEntity();
        final CategoryDTO categoryDTO = createCategoryDTO();

        return new Object[][]{{categoryCreateDTO, categoryEntity, categoryDTO}};
    }

    @DataProvider
    public Object[][] getCategoryEntityListAndCategoryDTOList() {
        final List<CategoryEntity> categoryEntityList = createCategoryEntityList();
        final List<CategoryDTO> categoryDTOList = createCategoryDTOList();

        return new Object[][]{{categoryEntityList, categoryDTOList}};
    }

    @DataProvider
    public Object[][] getCategoryEntityAndCategoryDTO() {
        final CategoryEntity categoryEntity = createCategoryEntity();
        final CategoryDTO categoryDTO = createCategoryDTO();

        return new Object[][]{{categoryEntity, categoryDTO}};
    }

    @DataProvider
    public Object[][] getCategoryEntity() {
        final CategoryEntity categoryEntity = createCategoryEntity();

        return new Object[][]{{categoryEntity}};
    }

    @DataProvider
    public Object[][] getCategoryCreateDTO() {
        final CategoryCreateAndUpdateDTO categoryCreateDTO = createCategoryCreateAndUpdateDTO();

        return new Object[][]{{categoryCreateDTO}};
    }

    private List<CategoryEntity> createCategoryEntityList() {
        final List<CategoryEntity> categoryEntityList = new ArrayList<>();
        final CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(1);
        categoryEntity1.setName("Languages & Frameworks");
        categoryEntity1.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");
        categoryEntity1.setRadar(new RadarEntity());
        categoryEntity1.setElementSet(new HashSet<>());
        categoryEntityList.add(categoryEntity1);

        final CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setId(1);
        categoryEntity2.setName("Methods & Patterns");
        categoryEntity2.setDescription("Here we put information on methods and patterns concerning development, continuous x, testing, organization, architecture, etc.");
        categoryEntity2.setRadar(new RadarEntity());
        categoryEntity2.setElementSet(new HashSet<>());
        categoryEntityList.add(categoryEntity2);

        return categoryEntityList;
    }

    private List<CategoryDTO> createCategoryDTOList() {
        final List<CategoryDTO> categoryDTOList = new ArrayList<>();
        final CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(1);
        categoryDTO1.setName("Languages & Frameworks");
        categoryDTO1.setDescription("We've placed development languages (such as Scala or Golang) here, as well as more low-level development frameworks (such as Play or Symfony), which are useful for implementing custom software of all kinds.");
        categoryDTOList.add(categoryDTO1);

        final CategoryDTO categoryDTO2 = new CategoryDTO();
        categoryDTO2.setId(1);
        categoryDTO2.setName("Methods & Patterns");
        categoryDTO2.setDescription("Here we put information on methods and patterns concerning development, continuous x, testing, organization, architecture, etc.");
        categoryDTOList.add(categoryDTO2);

        return categoryDTOList;
    }

}
