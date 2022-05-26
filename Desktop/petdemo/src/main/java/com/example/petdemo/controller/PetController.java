package com.example.petdemo.controller;


import com.example.petdemo.models.MyPet;
import com.example.petdemo.services.PetService;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
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
    @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(responseCode = "500", description = "Internal server error.")
    public ResponseEntity getPets(){
        logger.info("getAll");
        logger.debug("abbxbxbbc");
//        List<MyPet> myPets = petService.getAllPets();
//        logger.debug(myPets.get(0).getName());
//        return ResponseEntity.ok(myPets);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

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
//
//    @GetMapping("/error")
//    public Object getPetsError() {
//        return petService.getAllPetsWithError();
//    }




}
