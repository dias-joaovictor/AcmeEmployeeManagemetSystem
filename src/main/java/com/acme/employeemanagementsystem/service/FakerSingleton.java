package com.acme.employeemanagementsystem.service;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public final class FakerSingleton implements FakerService {

    private static FakerSingleton instance;

    private final Faker faker;

    private FakerSingleton(Faker faker) {
        this.faker = faker;
    }

    public static FakerSingleton getInstance() {
        if(instance == null){
            instance = new FakerSingleton(new Faker());
        }
        return instance;
    }

}
