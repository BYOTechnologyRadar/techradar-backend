package com.app.techradarbackend.service;

import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dataProvider.ElementDataProvider;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.mapper.ElementMapperImpl;
import com.app.techradarbackend.service.impl.ElementServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

public class ElementServiceTests {
    @Mock
    private ElementDAO elementDAO;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private ElementService elementService;

    @Spy
    private ElementMapper elementMapper = new ElementMapperImpl();

    @BeforeClass
    public void initMock() {
        elementService = new ElementServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProvider = "getElementCreateDTOAndElementEntityAndElementDTO", dataProviderClass = ElementDataProvider.class)
    public void ES_01_Add_Element_Successful(final ElementCreateDTO elementCreateDTO, final ElementEntity elementEntity, ElementDTO elementDTO) {
        when(elementMapper.mapCreateDTOToEntity(elementCreateDTO)).thenReturn(elementEntity);
        when(elementDAO.save(elementEntity)).thenReturn(elementEntity);
        when(elementService.addElement(elementCreateDTO)).thenReturn(elementDTO);
        when(elementMapper.mapEntityToDTO(elementEntity)).thenReturn(elementDTO);

        final ElementDTO element = elementService.addElement(elementCreateDTO);
        Assert.assertNotNull(element);
    }

    @Test(dataProvider = "getElementUpdateDTOAndElementEntityAndElementDTO", dataProviderClass = ElementDataProvider.class)
    public void ES_02_Update_Element_Successful(final ElementUpdateDTO elementUpdateDTO, final ElementEntity elementEntity, final ElementDTO elementDTO) {
        when(elementDAO.findById(1)).thenReturn(Optional.of(elementEntity));
        when(elementService.updateElement(1, elementUpdateDTO)).thenReturn(elementDTO);

        verify(elementMapper, times(1)).mapUpdateDTOToEntity(elementUpdateDTO, elementEntity);
    }

    @Test(dataProvider = "getElementEntityListAndElementDTOListAndElementEntity", dataProviderClass = ElementDataProvider.class)
    public void ES_03_Get_All_Elements_Successful(List<ElementEntity> elementEntityList, List<ElementDTO> elementDTOList) {
        when(elementDAO.findAll()).thenReturn(elementEntityList);
        when(elementService.getAllElements()).thenReturn(elementDTOList);

        verify(elementDAO, times(1)).findAll();
    }

    @Test(dataProvider = "getElementEntityAndElementDTO", dataProviderClass = ElementDataProvider.class)
    public void ES_04_Get_Element_Successful(ElementEntity elementEntity, ElementDTO elementDTO) {
        when(elementDAO.findById(1)).thenReturn(Optional.of(elementEntity));
        when(elementService.getElementById(1)).thenReturn(elementDTO);

        final ElementDTO element = elementService.getElementById(1);
        Assert.assertNotNull(element);
    }

    @Test
    public void ES_05_Delete_Element_Successful() {
        elementService.deleteElementById(1);

        verify(elementDAO, times(1)).deleteById(1);
    }

    @Test(enabled = false, expectedExceptions = ResourceNotFoundException.class)
    public void ES_06_Get_Element_Throws_ResourceNotFoundException() {
        try {
            ElementService elementServiceMock = mock(ElementService.class);
            when(elementServiceMock.getElementById(anyInt())).thenThrow(ResourceNotFoundException.class);

            elementServiceMock.getElementById(1);
        } catch (Exception e) {
            assertTrue(e instanceof ResourceNotFoundException);
        }

    }
}
