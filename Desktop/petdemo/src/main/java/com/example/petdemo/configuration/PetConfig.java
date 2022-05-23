package com.example.petdemo.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import test.model.Pet;

@Component
@Profile("dev")
public class PetConfig {
   public Pet test(){
       Pet p1 = new Pet();
       return p1;
   }


}
