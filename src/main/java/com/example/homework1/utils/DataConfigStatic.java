package com.example.homework1.utils;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfigStatic {

    @Bean
    public Faker faker(){
        return new Faker();
    }

}
