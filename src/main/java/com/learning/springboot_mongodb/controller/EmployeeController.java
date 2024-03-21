package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import com.learning.springboot_mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {


    private static final String DEFAULT_ACCESS= "ROLE_USER";
    private static final String[] MODERATOR_ACCESS = {"ROLE_USER, ROLE_MODERATOR"};
    private static final String[] ADMIN_ACCESS = {"ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN"};

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/employee")
    public ResponseEntity<HttpStatus> joinEmployee(@RequestBody Employee employee){
        employee.setRoles(DEFAULT_ACCESS);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/employee/addEmployee")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/employee/getEmplyee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id){
        return employeeService.receiveEmployeeById(id);
    }

    @GetMapping("/employee/getAccess/{id}/{roles}")
    public ResponseEntity giveAccessToEmployee(@PathVariable String id,
                                               @PathVariable String roles, Principal principal){
        Employee employee = employeeRepository.findById(id).get();
        List<String> ActiveRoles = getRoleOfLoggedInEmployee(principal);
        String newRole = "";
        if(ActiveRoles.contains(roles)){
            newRole = employee.getRoles()+","+roles;
            employee.setRoles(newRole);
        }
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private List<String> getRoleOfLoggedInEmployee(Principal principal){
        String roles = getLoggedInEmployee(principal).getRoles();
        List<String> assigned = Arrays.stream(roles.split(",")).collect(Collectors.toList());
        if (assigned.contains(MODERATOR_ACCESS)){
            return Arrays.stream(roles.split(",")).collect(Collectors.toList());
        } else if (assigned.contains(ADMIN_ACCESS)) {
            return Arrays.stream(roles.split(",")).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private Employee getLoggedInEmployee(Principal principal){
        return employeeRepository.findByUserName(principal.getName()).get();
    }
}
