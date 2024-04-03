package com.learning.springboot_mongodb.repository;

import com.learning.springboot_mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface UserRepository extends MongoRepository<User,String> {

}
