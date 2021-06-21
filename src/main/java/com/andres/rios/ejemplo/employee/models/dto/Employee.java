package com.andres.rios.ejemplo.employee.models.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Employee {

    private long id;
    private Person person;

    private Position position;

    private Integer salary;
}
