package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/getAllEmployee")
    public ResponseEntity <List< Employee >> receiveAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeServiceImpl.getAllEmployee());
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Optional<Employee>> receiveEmployeeById(@Validated @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeServiceImpl.getEmployeeById(id));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Optional<Employee>> addEmployee(@Validated @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeServiceImpl.createEmployee(employee));
    }

    @PutMapping("/modifyEmployee/{id}")
    public ResponseEntity < Employee > modifyEmployeeById(@Validated @PathVariable String id, @RequestBody Employee employee) throws Exception {
        employee.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeServiceImpl.updateEmployee(employee));
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public HttpStatus removeEmployee(@Validated @PathVariable String id) {
        this.employeeServiceImpl.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
