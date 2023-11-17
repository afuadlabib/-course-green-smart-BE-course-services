package com.smartgreen.course.mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Mapper <T, V>{
    abstract V mapToDto(T t);
    abstract T mapFrom(V v);
}
