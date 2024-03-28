package com.learning.springboot_mongodb;

import com.learning.springboot_mongodb.controller.EmployeeController;
import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import com.learning.springboot_mongodb.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SpringbootMongodbApplicationTests {
    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

   // @Test
    public void testAddEmployee(){
        // Mock behavior
        Employee employee = new Employee();
        when(employeeService.createEmployee(any(Employee.class))).thenReturn(String.valueOf(employee));

        // Call the controller method
        ResponseEntity<Employee> response = employeeController.addEmployee(new Employee());

        // Assert the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(employee, response.getBody());

        // Verify interactions
        verify(employeeService, times(1)).createEmployee(any(Employee.class));
        // Return the ResponseEntity
    }
}
