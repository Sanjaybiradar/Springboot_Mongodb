package com.learning.springboot_mongodb.repository;

import com.learning.springboot_mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface EmployeeRepository extends MongoRepository<Employee,String> {


    @Query("{'empName' : ?0}")
    Optional<Employee> findByUserName(String empName);
}
