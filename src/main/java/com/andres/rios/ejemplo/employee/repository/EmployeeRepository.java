package com.andres.rios.ejemplo.employee.repository;

import com.andres.rios.ejemplo.employee.models.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    public List<EmployeeEntity> findByPersonNameOrPositionName(String personName, String positionName);

    public List<EmployeeEntity> findAllByPositionId(long positionId);

}
