package com.smartgreen.course.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper();
    }

}
