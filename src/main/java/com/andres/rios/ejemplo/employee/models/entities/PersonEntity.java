package com.andres.rios.ejemplo.employee.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "city_name")
    private String cityName;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private EmployeeEntity employee;
}
