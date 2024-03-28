package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import com.learning.springboot_mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    private static final String DEFAULT_ACCESS= "ROLE_USER";
    private static final String[] MODERATOR_ACCESS = {"ROLE_USER, ROLE_MODERATOR"};
    private static final String[] ADMIN_ACCESS = {"ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN"};

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,EmployeeRepository employeeRepository){
        this.employeeService=employeeService;
        this.employeeRepository=employeeRepository;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id){
        return employeeService.receiveEmployeeById(id);
    }

    @PutMapping("/modifyEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeDto){

        employeeService.editEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/archiveEmployee/{id}")
    public ResponseEntity<HttpStatus> removeEmpById(@PathVariable String id){
        employeeService.eliminateEmpById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
