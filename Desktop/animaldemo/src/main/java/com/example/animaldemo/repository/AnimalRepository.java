package com.example.animaldemo.repository;

import com.example.animaldemo.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

}
