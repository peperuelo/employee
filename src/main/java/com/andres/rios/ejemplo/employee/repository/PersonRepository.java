package com.andres.rios.ejemplo.employee.repository;

import com.andres.rios.ejemplo.employee.models.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
