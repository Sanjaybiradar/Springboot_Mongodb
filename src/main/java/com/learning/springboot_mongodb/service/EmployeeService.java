package com.learning.springboot_mongodb.service;

import com.learning.springboot_mongodb.dto.HomeAddress;
import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    public Employee editEmployee(Employee employeeDto){
        Employee empEntity = new Employee(
                employeeDto.getId(),
                employeeDto.getEmpName(),
                employeeDto.getDesignation(),
                employeeDto.getHomeAddress(),
                employeeDto.getOfficeAddress()
        );
        return empRepo.save(empEntity);
    }

    public void eliminateEmpById(String id){
        empRepo.deleteById(id);
    }
}
