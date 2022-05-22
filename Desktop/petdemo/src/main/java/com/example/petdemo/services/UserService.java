package com.example.petdemo.services;

import com.example.petdemo.models.MyPet;
import com.example.petdemo.models.User;
import com.example.petdemo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return  this.userRepository.findAll();

    }

    public User getUserById(Integer id) {
        return this.userRepository.getById(id);
    }

    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }

    public User updateUser(Integer id, User user){
        User existedUser = this.userRepository.getById(id);
        BeanUtils.copyProperties(user,existedUser,"id");
        return this.userRepository.saveAndFlush(existedUser);

    }



}
