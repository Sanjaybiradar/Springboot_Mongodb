package com.learning.springboot_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empId;
    private String empName;
    private String dept;
    private String designation;
    private int salary;
}
