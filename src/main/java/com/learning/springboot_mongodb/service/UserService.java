package com.learning.springboot_mongodb.service;

import com.learning.springboot_mongodb.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
}
