package com.learning.springboot_mongodb.repository;

import com.learning.springboot_mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee,String> {


}
