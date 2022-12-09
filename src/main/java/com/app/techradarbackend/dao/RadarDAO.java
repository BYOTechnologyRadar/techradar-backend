package com.app.techradarbackend.dao;

import com.app.techradarbackend.entity.RadarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarDAO extends JpaRepository<RadarEntity, Integer>, QuerydslPredicateExecutor<RadarEntity> {
}
