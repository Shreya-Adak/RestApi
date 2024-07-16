package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//for creating mapper bean
public class MapperConfig {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
