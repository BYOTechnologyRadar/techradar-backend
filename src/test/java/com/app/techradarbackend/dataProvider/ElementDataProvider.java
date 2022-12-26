package com.app.techradarbackend.dataProvider;

import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementInfoDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class ElementDataProvider {
    @DataProvider
    public static Object[][] getElementCreateDTOAndElementEntityAndElementDTO() {
        final ElementCreateDTO elementCreateDTO = createElementCreateDTO();
        final ElementEntity elementEntity = createElementEntity();
        final ElementDTO elementDTO = createElementDTO();

        return new Object[][]{{elementCreateDTO, elementEntity, elementDTO}};
    }

    @DataProvider
    public static Object[][] getElementUpdateDTOAndElementEntityAndElementDTO() {
        final ElementUpdateDTO elementUpdateDTO = createElementUpdateDTO();
        final ElementEntity elementEntity = createElementEntity();
        final ElementDTO elementDTO = createElementDTO();

        return new Object[][]{{elementUpdateDTO, elementEntity, elementDTO}};
    }

    @DataProvider
    public static Object[][] getElementEntityListAndElementDTOListAndElementEntity() {
        final List<ElementEntity> elementEntityList = createElementEntityList();
        final List<ElementDTO> elementDTOList = createElementDTOList();

        return new Object[][]{{elementEntityList, elementDTOList}};
    }

    @DataProvider
    public static Object[][] getElementEntityAndElementDTO() {
        final ElementEntity elementEntity = createElementEntity();
        final ElementDTO elementDTO = createElementDTO();

        return new Object[][]{{elementEntity, elementDTO}};
    }

    @DataProvider
    public static Object[][] getElementEntityAndElementInfoDTO() {
        final ElementEntity elementEntity = createElementEntity();
        final ElementInfoDTO elementInfoDTO = createElementInfoDTO();

        return new Object[][]{{elementEntity, elementInfoDTO}};
    }

    @DataProvider
    public static Object[][] getElementEntity() {
        final ElementEntity elementEntity = createElementEntity();

        return new Object[][]{{elementEntity}};
    }

    @DataProvider
    public static Object[][] getElementCreateDTO() {
        final ElementCreateDTO elementCreateDTO = createElementCreateDTO();

        return new Object[][]{{elementCreateDTO}};
    }

    private static ElementEntity createElementEntity() {
        final ElementEntity elementEntity = new ElementEntity();
        elementEntity.setId(1);
        elementEntity.setName("Java");
        elementEntity.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");
        elementEntity.setLevel(ElementLevel.ADOPT);
        elementEntity.setVersion(ElementVersion.New);
        elementEntity.setStatus(ElementStatus.ACTIVE);
        elementEntity.setCategory(new CategoryEntity());

        return elementEntity;
    }

    private static ElementDTO createElementDTO() {
        final ElementDTO elementDTO = new ElementDTO();
        elementDTO.setId(1);
        elementDTO.setName("Java");
        elementDTO.setLevel(ElementLevel.ADOPT);
        elementDTO.setVersion(ElementVersion.New);
        elementDTO.setStatus(ElementStatus.ACTIVE);

        return elementDTO;
    }

    private static ElementInfoDTO createElementInfoDTO() {
        final ElementInfoDTO elementInfoDTO = new ElementInfoDTO();
        final ElementDTO elementDTO = createElementDTO();
        elementInfoDTO.setCategoryId(1);
        elementInfoDTO.setElementDTO(elementDTO);
        elementInfoDTO.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");

        return elementInfoDTO;
    }

    private static ElementCreateDTO createElementCreateDTO() {
        final ElementCreateDTO elementCreateDTO = new ElementCreateDTO();
        elementCreateDTO.setName("Java");
        elementCreateDTO.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");
        elementCreateDTO.setLevel(ElementLevel.ADOPT);
        elementCreateDTO.setStatus(ElementStatus.ACTIVE);
        elementCreateDTO.setVersion(ElementVersion.Unchanged);
        elementCreateDTO.setCategoryId(1);

        return elementCreateDTO;
    }

    private static ElementUpdateDTO createElementUpdateDTO() {
        final ElementUpdateDTO elementUpdateDTO = new ElementUpdateDTO();
        elementUpdateDTO.setName("Java");
        elementUpdateDTO.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");
        elementUpdateDTO.setLevel(ElementLevel.ADOPT);
        elementUpdateDTO.setStatus(ElementStatus.ACTIVE);
        elementUpdateDTO.setVersion(ElementVersion.Unchanged);

        return elementUpdateDTO;
    }

    private static List<ElementEntity> createElementEntityList() {
        List<ElementEntity> elementEntityList = new ArrayList<>();
        final ElementEntity elementEntity1 = new ElementEntity();
        elementEntity1.setName("Java");
        elementEntity1.setDescription("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");
        elementEntity1.setLevel(ElementLevel.ADOPT);
        elementEntity1.setStatus(ElementStatus.ACTIVE);
        elementEntity1.setCategory(new CategoryEntity());
        elementEntity1.setVersion(ElementVersion.Changed);
        elementEntityList.add(elementEntity1);

        final ElementEntity elementEntity2 = new ElementEntity();
        elementEntity2.setName("Spring Boot");
        elementEntity2.setDescription("Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.");
        elementEntity2.setLevel(ElementLevel.TRIAL);
        elementEntity2.setStatus(ElementStatus.ACTIVE);
        elementEntity2.setCategory(new CategoryEntity());
        elementEntity2.setVersion(ElementVersion.Unchanged);
        elementEntityList.add(elementEntity2);

        return elementEntityList;
    }

    private static List<ElementDTO> createElementDTOList() {
        final List<ElementDTO> elementDTOList = new ArrayList<>();
        final ElementDTO elementDTO1 = new ElementDTO();
        elementDTO1.setName("Java");
        elementDTO1.setLevel(ElementLevel.ADOPT);
        elementDTO1.setStatus(ElementStatus.ACTIVE);
        elementDTO1.setVersion(ElementVersion.Changed);
        elementDTOList.add(elementDTO1);

        final ElementDTO elementDTO2 = new ElementDTO();
        elementDTO2.setName("Spring Boot");
        elementDTO2.setLevel(ElementLevel.TRIAL);
        elementDTO2.setStatus(ElementStatus.ACTIVE);
        elementDTO2.setVersion(ElementVersion.Unchanged);
        elementDTOList.add(elementDTO2);

        return elementDTOList;
    }


}
