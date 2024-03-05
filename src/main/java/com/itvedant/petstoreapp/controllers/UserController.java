package com.itvedant.petstoreapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstoreapp.entities.User;
import com.itvedant.petstoreapp.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    //Create
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody @Valid User newUser){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(this.service.addUser(newUser));
    }    

    //Read All
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(this.service.getAll());
    }

    //Read One
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        User foundUser = this.service.getByID(id);
        if(foundUser == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("User with this ID does not exists");
        else
            return ResponseEntity.ok(foundUser);
    }

    //Update
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,
                                        @RequestBody User updatedUser){
        User foundUser = this.service.getByID(id);
        if(foundUser == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("User with this ID does not exists");
        else
            return ResponseEntity.ok(this.service.updateUser(id, updatedUser));
    }

    //Delete
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        User foundUser = this.service.getByID(id);
        if(foundUser == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("User with this ID does not exists");
        else{
            this.service.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

}
