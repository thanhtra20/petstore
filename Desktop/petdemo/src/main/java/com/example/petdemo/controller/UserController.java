package com.example.petdemo.controller;

import com.example.petdemo.models.Animal;
import com.example.petdemo.models.MyPet;
import com.example.petdemo.models.User;
import com.example.petdemo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/get-all")
    public ResponseEntity getUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

}
