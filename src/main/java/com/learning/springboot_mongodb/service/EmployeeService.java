package com.learning.springboot_mongodb.service;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    public String createEmployee(Employee employee){
        empRepo.save(employee);
        return "Employee Object Created in Database!";
    }

    public Optional<Employee> receiveEmployeeById(String id) {
        return empRepo.findById(id);
    }
}
