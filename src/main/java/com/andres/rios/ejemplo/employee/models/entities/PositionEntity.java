package com.andres.rios.ejemplo.employee.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employee;
}
