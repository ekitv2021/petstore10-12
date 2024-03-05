package com.itvedant.petstoreapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.petstoreapp.entities.User;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();

    //Create
    public User addUser(User newUser){
        newUser.setId(atomic.incrementAndGet());
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }

    //Read All
    public List<User> getAll(){
        return new ArrayList<User>(userMap.values());
    }

    //Read One
    public User getByID(Integer id){
        return userMap.get(id);
    }

    //Update
    public User updateUser(Integer id, User updatedUser){
        updatedUser.setId(id);
        userMap.put(id, updatedUser);
        return updatedUser;
    }

    //Delete
    public void deleteUser(Integer id){
        userMap.remove(id);
    }
}
