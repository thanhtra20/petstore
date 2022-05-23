package com.example.petdemo.controller;

import com.example.petdemo.models.Animal;
import com.example.petdemo.models.MyPet;
import com.example.petdemo.services.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pet")
public class PetController {

    Logger logger = LoggerFactory.getLogger(PetController.class);

    private PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/get-all")
    public ResponseEntity getPets(){
        logger.info("getAll");
        logger.debug("abbxbxbbc");
        List<MyPet> myPets = petService.getAllPets();
        logger.debug(myPets.get(0).getName());
        return ResponseEntity.ok(myPets);

    }

    @PostMapping("/add")
    public ResponseEntity addPet(@RequestBody MyPet myPet){
        petService.addPet(myPet);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public MyPet getPetById(@PathVariable("id") Integer id){
        return petService.getPetById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") Integer id){
        petService.deletePetById(id);
    }

    @PutMapping("{id}")
    public MyPet updatePet(@PathVariable Integer id, @RequestBody MyPet myPet){
        return petService.updatePet(id, myPet);
    }





}
