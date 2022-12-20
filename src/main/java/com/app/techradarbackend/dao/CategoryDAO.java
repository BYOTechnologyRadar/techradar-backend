package com.app.techradarbackend.dao;

import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.RadarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer>, QuerydslPredicateExecutor<CategoryEntity> {
    List<CategoryEntity> getCategoryEntitiesByRadar(RadarEntity radar);
}
