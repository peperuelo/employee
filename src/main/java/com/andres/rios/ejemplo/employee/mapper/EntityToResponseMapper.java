package com.andres.rios.ejemplo.employee.mapper;

import com.andres.rios.ejemplo.employee.models.dto.Employee;
import com.andres.rios.ejemplo.employee.models.dto.Person;
import com.andres.rios.ejemplo.employee.models.dto.Position;
import com.andres.rios.ejemplo.employee.models.entities.EmployeeEntity;
import com.andres.rios.ejemplo.employee.models.entities.PersonEntity;
import com.andres.rios.ejemplo.employee.models.entities.PositionEntity;
import org.springframework.stereotype.Component;


@Component
public class EntityToResponseMapper implements Mapper<EmployeeEntity, Employee> {
    @Override
    public Employee map(EmployeeEntity input) {
        Employee response = new Employee();
        response.setSalary(input.getSalary());
        response.setPerson(toPersonEntity(input.getPerson()));
        response.setPosition(toPositionEntity(input.getPosition()));
        response.setId(input.getId());
        return response;
    }

    private Person toPersonEntity(PersonEntity person) {
        Person response = new Person();
        response.setAddress(person.getAddress());
        response.setCellphone(person.getCellphone());
        response.setCityName(person.getCityName());
        response.setName(person.getName());
        response.setLastName(person.getLastName());
        return response;
    }

    private Position toPositionEntity(PositionEntity position) {
        Position response = new Position();
        response.setName(position.getName());
        return response;
    }
}
