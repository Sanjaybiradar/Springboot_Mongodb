package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getEmplyee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id){
        return employeeService.receiveEmployeeById(id);
    }
}
