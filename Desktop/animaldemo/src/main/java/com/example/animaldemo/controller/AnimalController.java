package com.example.animaldemo.controller;

import com.example.animaldemo.models.Animal;
import com.example.animaldemo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService service;

    @Autowired
    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Animal> getByType(@RequestParam("type") String type) {
        return service.getByType(type);
    }

    @PostMapping("/addall")
    public void addAllAnimal() {
        service.addAllAnimals();
    }
}
