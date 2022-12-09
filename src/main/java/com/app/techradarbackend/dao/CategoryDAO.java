package com.app.techradarbackend.dao;

import com.app.techradarbackend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer>, QuerydslPredicateExecutor<CategoryEntity> {
}
