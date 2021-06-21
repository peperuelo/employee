package com.andres.rios.ejemplo.employee.mapper;


public interface Mapper<I,O> {

    public O map(I input);
}
