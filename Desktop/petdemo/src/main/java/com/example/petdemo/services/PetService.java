package com.example.petdemo.services;

import com.example.petdemo.models.Animal;
import com.example.petdemo.models.MyPet;
import invalidPackageName.ApiClient;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.PetApi;
import test.model.Pet;
import com.example.petdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public MyPet addPet(MyPet myPet) throws NoSuchElementException {
//        RestTemplate restTemplate = new RestTemplate();
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Pet> responseEntity = null;
//
//        try{
//            String fooResourceUrl
//                    = "https://petstore.swagger.io/v2/pet";
//            responseEntity = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, new HttpEntity(""), Pet.class);
//
//        }catch(Exception e){
//            return null;
//        }
//        return petRepository.save(myPet);
//        ApiClient result;
//        final var baseUrl = "https://petstore.swagger.io/v2";
//        var template = new RestTemplate();
//        result = new ApiClient(template);
//        result.setBasePath(baseUrl);
//        Pet p1 = new Pet();
//        p1.setName(animal.getName());
////        p1.setStatus(Pet.StatusEnum.SOLD);
//        p1.setId((long)animal.getId());
//        PetApi pet1 = new PetApi(result);
//        pet1.addPet(p1);
//        Pet p2 =pet1.getPetById((long)animal.getId());
//
//       return  null;

//        if (animal.getType().equals("dog")) {
//            return this.petRepository.save(MyPet.fromAnimal(animal));
//        }
        return this.petRepository.save(myPet);
    }


    public List<MyPet> getPetByStatus() {
        ApiClient apiClient;
        final var baseUrl = "https://petstore.swagger.io/v2";
        var template = new RestTemplate();
        apiClient = new ApiClient(template);
        apiClient.setBasePath(baseUrl);
        List<?> lists = (List<?>) template.getForEntity("/pet/findByStatus", List.class);
        System.out.println(lists);
        return (List<MyPet>) lists;
    }

    public List<MyPet> getAllPets() {
        return  this.petRepository.findAll();

    }

    public MyPet getPetById(Integer id) {
       return this.petRepository.getById(id);
    }

    public void deletePetById(Integer id) {
        this.petRepository.deleteById(id);
    }

     public MyPet updatePet(Integer id, MyPet myPet){
        MyPet existedPet = this.petRepository.getById(id);
        BeanUtils.copyProperties(myPet,existedPet,"id");
        return this.petRepository.saveAndFlush(existedPet);

    }

}
