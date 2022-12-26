package com.app.techradarbackend.mapper;


import com.app.techradarbackend.dataProvider.ElementDataProvider;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.entity.ElementEntity;
import org.mockito.InjectMocks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ElementMapperTests {
    @InjectMocks
    private ElementMapper elementMapper = new ElementMapperImpl();

    @Test(dataProvider = "getElementEntity", dataProviderClass = ElementDataProvider.class)
    public void EM_01_mapEntityToDTO(final ElementEntity elementEntity) {
        ElementDTO elementDTO = elementMapper.mapEntityToDTO(elementEntity);

        assertEquals(elementDTO.getId(), elementEntity.getId());
        assertEquals(elementDTO.getName(), elementEntity.getName());
        assertEquals(elementDTO.getLevel(), elementEntity.getLevel());
        assertEquals(elementDTO.getStatus(), elementEntity.getStatus());
        assertEquals(elementDTO.getVersion(), elementEntity.getVersion());
    }

    @Test(dataProvider = "getElementCreateDTO", dataProviderClass = ElementDataProvider.class)
    public void EM_02_mapCreateDTOToEntity(final ElementCreateDTO elementCreateDTO) {
        ElementEntity elementEntity = elementMapper.mapCreateDTOToEntity(elementCreateDTO);

        assertEquals(elementEntity.getName(), elementCreateDTO.getName());
        assertEquals(elementEntity.getLevel(), elementCreateDTO.getLevel());
        assertEquals(elementEntity.getStatus(), elementCreateDTO.getStatus());
        assertEquals(elementEntity.getVersion(), elementCreateDTO.getVersion());
        assertEquals(elementEntity.getDescription(), elementCreateDTO.getDescription());
        assertEquals(elementEntity.getCategory().getId(), elementCreateDTO.getCategoryId());
    }


}
