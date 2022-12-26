package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementInfoDTO;
import com.app.techradarbackend.dto.ElementSearchDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.entity.QElementEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.service.CategoryService;
import com.app.techradarbackend.service.ElementService;
import com.querydsl.core.BooleanBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ElementServiceImpl implements ElementService {
    private ElementDAO elementDAO;
    private ElementMapper elementMapper;
    private CategoryService categoryService;

    @Autowired
    public ElementServiceImpl(ElementDAO elementDAO, ElementMapper elementMapper, CategoryService categoryService) {
        this.elementDAO = elementDAO;
        this.elementMapper = elementMapper;
        this.categoryService = categoryService;
    }

    @Override
    public ElementDTO addElement(ElementCreateDTO elementCreateDTO) {
        ElementEntity element = elementMapper.mapCreateDTOToEntity(elementCreateDTO);
        CategoryEntity category = categoryService.getById(elementCreateDTO.getCategoryId());
        element.setCategory(category);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public ElementDTO updateElement(int elementId, ElementUpdateDTO elementUpdateDTO) {
        ElementEntity element = getById(elementId);
        elementMapper.mapUpdateDTOToEntity(elementUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public ElementInfoDTO getElementById(int elementId) {
        ElementEntity element = getById(elementId);
        return elementMapper.mapEntityToInfoDTO(element);
    }

    @Override
    public List<ElementDTO> searchElementByName(ElementSearchDTO elementSearchDTO) {
        BooleanBuilder booleanBuilder = booleanBuilderForElementSearch(elementSearchDTO);
        List<ElementEntity> elementList = (List<ElementEntity>) elementDAO.findAll(booleanBuilder);
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    @Override
    public List<ElementDTO> getAllElements() {
        List<ElementEntity> elementList = elementDAO.findAll();
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    @Override
    public List<ElementDTO> getAllElementsByCategoryId(int categoryId) {
        CategoryEntity category = categoryService.getById(categoryId);
        List<ElementEntity> elementList = elementDAO.getElementEntitiesByCategory(category);
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    @Override
    public void deleteElementById(int elementId) {
        elementDAO.deleteById(elementId);
    }

    @Override
    public ElementEntity getById(int elementId) {
        return elementDAO.findById(elementId).orElseThrow(
                () -> new ResourceNotFoundException("Element", "ID", elementId));
    }

    @Override
    public ElementDTO updateElementCategory(int elementId, ElementCategoryUpdateDTO elementCategoryUpdateDTO) {
        ElementEntity element = getById(elementId);
        CategoryEntity category = categoryService.getById(elementCategoryUpdateDTO.getCategoryId());
        element.setCategory(category);
        elementMapper.mapCategoryPatchDTOToEntity(elementCategoryUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    private BooleanBuilder booleanBuilderForElementSearch(ElementSearchDTO elementSearchDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QElementEntity qElementEntity = QElementEntity.elementEntity;

        if (elementSearchDTO.getName() != null && !elementSearchDTO.getName().isEmpty()) {
            booleanBuilder.and(qElementEntity.name.containsIgnoreCase(elementSearchDTO.getName()));
        }
        return booleanBuilder;
    }
}
