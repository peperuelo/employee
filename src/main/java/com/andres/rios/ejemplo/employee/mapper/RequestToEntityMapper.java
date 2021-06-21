package com.andres.rios.ejemplo.employee.mapper;

import com.andres.rios.ejemplo.employee.models.dto.Employee;
import com.andres.rios.ejemplo.employee.models.dto.Person;
import com.andres.rios.ejemplo.employee.models.dto.Position;
import com.andres.rios.ejemplo.employee.models.entities.EmployeeEntity;
import com.andres.rios.ejemplo.employee.models.entities.PersonEntity;
import com.andres.rios.ejemplo.employee.models.entities.PositionEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestToEntityMapper implements Mapper<Employee, EmployeeEntity> {
    @Override
    public EmployeeEntity map(Employee input) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setSalary(input.getSalary());
        entity.setPerson(toPersonEntity(input.getPerson()));
        entity.setPosition(toPositionEntity(input.getPosition()));
        return entity;
    }

    private PersonEntity toPersonEntity(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setAddress(person.getAddress());
        entity.setCellphone(person.getCellphone());
        entity.setCityName(person.getCityName());
        entity.setName(person.getName());
        entity.setLastName(person.getLastName());
        return entity;
    }

    private PositionEntity toPositionEntity(Position position) {
        PositionEntity entity = new PositionEntity();
        entity.setName(position.getName());
        return entity;
    }
}
