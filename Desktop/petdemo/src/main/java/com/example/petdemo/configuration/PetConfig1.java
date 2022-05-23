package com.example.petdemo.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import test.model.Pet;

@Component
@Profile("test")
public class PetConfig1 {
    public Pet test(){
        Pet p2 = new Pet();
        return p2;
    }
}
