package com.andres.rios.ejemplo.employee.controller;

import com.andres.rios.ejemplo.employee.models.dto.Department;
import com.andres.rios.ejemplo.employee.models.dto.Employee;
import com.andres.rios.ejemplo.employee.service.EmployeeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeApi employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required=false) String name, @RequestParam(required=false) String position) {
        return ResponseEntity.ok(employeeService.getAllEmployees(position, name));
    }

    @GetMapping("/all/by-department")
    public ResponseEntity<List<Department>> getAllEmployeesByDepartment() {
        return ResponseEntity.ok(employeeService.getAllEmployeesByDepartment());
    }

}
