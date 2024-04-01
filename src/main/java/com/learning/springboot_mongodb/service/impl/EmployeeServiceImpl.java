package com.learning.springboot_mongodb.service.impl;

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import com.learning.springboot_mongodb.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> createEmployee(Employee employee) {
        LOGGER.info("Creating Employee Object Function Triggered!");
        if (!employeeRepository.existsById(employee.getId())) {
            //employeeRepository.save(employee);
            return Optional.of(mongoTemplate.save(employee));
        }
        else {
            LOGGER.info(employee.getId()+" : Already exists");
        }
        //return employeeRepository.findById(employee.getId());
        return Optional.ofNullable(mongoTemplate.findById(employee.getId(), Employee.class));
    }


    @Override
    public Employee updateEmployee(Employee employee) throws Exception {
        LOGGER.info("Updating Employee Object Function Triggered!");
        Optional<Employee> empEntity = employeeRepository.findById(employee.getId());

        if (empEntity.isPresent()){
            Employee empUpdate = empEntity.get();
            empUpdate.setId(employee.getId());
            empUpdate.setEmpName(employee.getEmpName());
            empUpdate.setDesignation(employee.getDesignation());
            empUpdate.setHomeAddress(employee.getHomeAddress());
            empUpdate.setOfficeAddress(employee.getOfficeAddress());
            return employeeRepository.save(empUpdate);
        }
        else {
            throw new Exception(employee.getId()+" : Employee object does not exist");
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        LOGGER.info("Getting All Employees Object Function Triggered!");
        //return employeeRepository.findAll();
        return mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Optional<Employee> getEmployeeById(String Id) {
        LOGGER.info("Getting Employee Object By Id Function Triggered!");
       /* Optional<Employee> employee = employeeRepository.findById(Id);

        if (employee.isPresent()){
            return Optional.of(employee.get());
        }

        return employee;*/
        return Optional.ofNullable(mongoTemplate.findById(Id, Employee.class));
    }

    @Override
    public void deleteEmployee(String id) {
        LOGGER.info("Deleting Employee Object By Id Function Triggered!");
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            employeeRepository.deleteById(id);
        }
        //return mongoTemplate.remove(id);
    }
}
