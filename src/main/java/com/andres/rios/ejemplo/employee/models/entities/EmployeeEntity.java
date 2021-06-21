package com.andres.rios.ejemplo.employee.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "person")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "position", updatable = false, nullable = false)
    private PositionEntity position;

    private Integer salary;

}
