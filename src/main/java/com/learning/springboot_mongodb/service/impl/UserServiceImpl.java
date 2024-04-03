package com.learning.springboot_mongodb.service.impl;

import com.learning.springboot_mongodb.entity.User;
import com.learning.springboot_mongodb.repository.UserRepository;
import com.learning.springboot_mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        //return mongoTemplate.findAll(User.class);
        return userRepository.findAll();
    }


    public User createUser(User user) {
        //return userRepository.save(user);
        return mongoTemplate.save(user);
    }
}
