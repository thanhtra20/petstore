package com.example.petdemo.repository;

import com.example.petdemo.models.MyPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<MyPet,Integer> {

}
