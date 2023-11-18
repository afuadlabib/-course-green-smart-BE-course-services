package com.smartgreen.course.mappers;


public abstract class Mapper <T, V>{
    abstract V mapToDto(T t);
    abstract T mapFrom(V v);
}
