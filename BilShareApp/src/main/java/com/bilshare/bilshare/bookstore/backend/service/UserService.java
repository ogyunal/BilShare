package com.bilshare.bilshare.bookstore.backend.service;

import com.bilshare.bilshare.bookstore.backend.entity.User;
import com.bilshare.bilshare.bookstore.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    //private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    //public UserService(UserRepository userRepository) {
        //this.userRepository = userRepository;
    //}

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public long count() {
        return userRepository.count();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void save(User user) {
        User newUser = new User(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);
    }
}
