package com.example.petdemo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "auth_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer userId;
    @Column
    private String name;

    @OneToMany(mappedBy = "user")
    private List<MyPet> myPets;

    public User(Integer userId, String name, List<MyPet> myPets) {
        this.userId = userId;
        this.name = name;
        this.myPets = myPets;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
