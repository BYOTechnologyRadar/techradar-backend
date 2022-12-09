package com.app.techradarbackend.dao;

import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.enums.ElementVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementDAO extends JpaRepository<ElementEntity, Integer>, QuerydslPredicateExecutor<ElementEntity> {
    List<ElementEntity> getElementEntitiesByLevel(ElementLevel elementLevel);

    List<ElementEntity> getElementEntitiesByStatus(ElementStatus elementStatus);

    List<ElementEntity> getElementEntitiesByVersion(ElementVersion elementVersion);

    List<ElementEntity> getElementEntitiesByCategory(CategoryEntity category);

}
