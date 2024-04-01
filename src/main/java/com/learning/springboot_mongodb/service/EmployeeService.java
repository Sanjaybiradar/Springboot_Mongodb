package com.learning.springboot_mongodb.service;

import com.learning.springboot_mongodb.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee>   createEmployee(Employee Employee);

    Employee updateEmployee(Employee Employee) throws Exception;

    List< Employee > getAllEmployee();

    Optional<Employee> getEmployeeById(String EmployeeId);

    void deleteEmployee(String id);

}
