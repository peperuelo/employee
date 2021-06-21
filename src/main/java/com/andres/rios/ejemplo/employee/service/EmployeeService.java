package com.andres.rios.ejemplo.employee.service;

import com.andres.rios.ejemplo.employee.mapper.Mapper;
import com.andres.rios.ejemplo.employee.models.dto.Department;
import com.andres.rios.ejemplo.employee.models.dto.Employee;
import com.andres.rios.ejemplo.employee.models.dto.Person;
import com.andres.rios.ejemplo.employee.models.dto.Position;
import com.andres.rios.ejemplo.employee.models.entities.EmployeeEntity;
import com.andres.rios.ejemplo.employee.models.entities.PersonEntity;
import com.andres.rios.ejemplo.employee.models.entities.PositionEntity;
import com.andres.rios.ejemplo.employee.repository.EmployeeRepository;
import com.andres.rios.ejemplo.employee.repository.PersonRepository;
import com.andres.rios.ejemplo.employee.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeApi {

    private final EmployeeRepository employeeRepository;

    private final PositionRepository positionRepository;

    private final PersonRepository personRepository;

    private final Mapper<Employee, EmployeeEntity> requestToEntityMapper;

    private final Mapper<EmployeeEntity, Employee> entityToResponseMapper;


    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = requestToEntityMapper.map(employee);
        entity.setPosition(positionRepository.findPositionEntityByName(employee.getPosition().getName()));
        return entityToResponseMapper.map(
                employeeRepository.save(entity)
        );
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeEntity currentEntity = employeeRepository.getById(employee.getId());
        return entityToResponseMapper.map(
                employeeRepository.save(
                        compareStructures(employee, currentEntity)
                )
        );
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(
                requestToEntityMapper.map(employee)
        );
    }

    @Override
    public List<Employee> getAllEmployees(String position, String name) {
        if (StringUtils.isNotEmpty(name) || StringUtils.isNotEmpty(position)) {
            List<EmployeeEntity> employeeList = employeeRepository.findByPersonNameOrPositionName(
                    name, position);
            if (!employeeList.isEmpty()) {
                employeeList
                        .stream()
                        .map((entity) -> entityToResponseMapper.map(entity))
                        .collect(Collectors.toList());
            }
        }
        return employeeRepository
                .findAll()
                .stream()
                .filter((entity) -> entity.getPerson() != null)
                .map((entity) -> entityToResponseMapper.map(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Department> getAllEmployeesByDepartment() {
        List<PositionEntity> allPositions = positionRepository.findAll();
        List<Department> result = new ArrayList();
        for (PositionEntity department : allPositions) {
            List<EmployeeEntity> departmentEmployees = employeeRepository.findAllByPositionId(department.getId());
            result.add(Department.builder()
                    .id(department.getId())
                    .name(department.getName())
                    .employees(
                            departmentEmployees.stream()
                                    .filter((entity) -> entity.getPerson() != null)
                                    .map(
                                            (entity) -> entityToResponseMapper.map(entity))
                                    .collect(Collectors.toList())
                    ).build()
            );
        }
        return result;
    }

    private EmployeeEntity compareStructures(Employee newInfoEmployee, EmployeeEntity currentEntity) {
        currentEntity.setSalary((newInfoEmployee.getSalary() == null) ? currentEntity.getSalary() : newInfoEmployee.getSalary());
        currentEntity.setPosition(sanitizePosition(newInfoEmployee.getPosition(), currentEntity.getPosition()));
        currentEntity.setPerson(sanitizePerson(newInfoEmployee.getPerson(), currentEntity.getPerson()));
        return currentEntity;
    }

    private PositionEntity sanitizePosition(Position newInfoPosition, PositionEntity currentPosition) {
        currentPosition.setName((newInfoPosition.getName() == null) ? currentPosition.getName() : newInfoPosition.getName());
        return currentPosition;
    }

    private PersonEntity sanitizePerson(Person newInfoPerson, PersonEntity currentPerson) {
        currentPerson.setName((newInfoPerson.getName() == null) ? currentPerson.getName() : newInfoPerson.getName());
        currentPerson.setLastName((newInfoPerson.getLastName() == null) ? currentPerson.getLastName() : newInfoPerson.getLastName());
        currentPerson.setCellphone((newInfoPerson.getCellphone() == null) ? currentPerson.getCellphone() : newInfoPerson.getCellphone());
        currentPerson.setAddress((newInfoPerson.getAddress() == null) ? currentPerson.getAddress() : newInfoPerson.getAddress());
        currentPerson.setCityName((newInfoPerson.getCityName() == null) ? currentPerson.getCityName() : newInfoPerson.getCityName());
        return currentPerson;
    }

}
