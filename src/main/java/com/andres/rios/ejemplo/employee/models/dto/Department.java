package com.andres.rios.ejemplo.employee.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Builder
public class Department {

    private long id;
    private String name;
    private List<Employee> employees;
}
