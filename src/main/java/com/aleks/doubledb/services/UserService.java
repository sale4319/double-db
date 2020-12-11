package com.aleks.doubledb.services;

import com.aleks.doubledb.models.User;
import com.aleks.doubledb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Integer Id) {
        return userRepository.findById(Id);
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer Id) {
        userRepository.deleteById(Id);
    }

    /*public boolean checkUser(Integer Id) {
        Optional<User> u= userRepository.findById(Id);
        if(u!=null)
            return true;
        return false;
    }*/
}
