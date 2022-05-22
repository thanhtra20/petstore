package com.example.animaldemo.service;

import com.example.animaldemo.models.Animal;
import com.example.animaldemo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final RestTemplate template;

    @Autowired
    public AnimalService(AnimalRepository repository, RestTemplate template) {
        this.animalRepository = repository;
        this.template = template;
    }

    public List<Animal> getByType(String type) {
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<List> response = template.getForEntity(
                "https://ttest.free.beeceptor.com/animals",
                List.class
        );
        System.out.println(response.getBody());
        final List<LinkedHashMap<String, ?>> responseBody = response.getBody();
        final List<Animal> allAnimals = new LinkedList<>();
        responseBody.forEach(item -> allAnimals.add(new Animal(
                (Integer)item.get("id"),
                (String)item.get("name"),
                (String)item.get("type"),
                (String)item.get("status")
        )));

        return Objects.requireNonNull(allAnimals)
                .stream()
                .filter(animal -> animal.getType().equals(type))
                .collect(Collectors.toList());
    }


    public void addAllAnimals() {
        final ResponseEntity<List> response = template.getForEntity(
                "https://ttest.free.beeceptor.com/animals",
                List.class
        );
        System.out.println(response.getBody());
        final List<LinkedHashMap<String, ?>> responseBody = response.getBody();
        final List<Animal> allAnimals = Objects.requireNonNull(responseBody).stream().map(item -> new Animal(
                (Integer)item.get("id"),
                (String)item.get("name"),
                (String)item.get("type"),
                (String)item.get("status")
        )).collect(Collectors.toList());


        List<Animal> dogs = allAnimals.stream().filter(animal -> animal.getType().equals("dog")).collect(Collectors.toList()) ;
        System.out.println("H");


        for (Animal dog : dogs) {
            template.exchange("http://localhost:8080/pet/add", HttpMethod.POST, new HttpEntity<>(dog), Void.class);

        }

    }

}
