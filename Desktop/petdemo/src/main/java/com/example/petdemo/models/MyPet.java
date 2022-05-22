package com.example.petdemo.models;


import javax.persistence.*;

@Entity
@Table(name = "my_pet")
public class MyPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MyPet() {
    }


    public MyPet(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static MyPet fromAnimal(Animal animal) {
        return new MyPet(animal.getId(), animal.getName(), animal.getStatus());
    }
}

