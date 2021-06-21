package com.andres.rios.ejemplo.employee.service;

import com.andres.rios.ejemplo.employee.models.dto.Department;
import com.andres.rios.ejemplo.employee.models.dto.Employee;

import java.util.List;

public interface EmployeeApi {

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public List<Employee> getAllEmployees(String position, String name);

    public List<Department> getAllEmployeesByDepartment();
}
