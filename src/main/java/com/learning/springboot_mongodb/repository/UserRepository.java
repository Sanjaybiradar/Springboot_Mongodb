package com.learning.springboot_mongodb.repository;

import com.learning.springboot_mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
