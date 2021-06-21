package com.andres.rios.ejemplo.employee.repository;

import com.andres.rios.ejemplo.employee.models.entities.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    public PositionEntity findPositionEntityByName(String name);
}
