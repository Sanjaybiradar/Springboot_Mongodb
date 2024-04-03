package com.learning.springboot_mongodb.entity;

import com.learning.springboot_mongodb.dto.HomeAddress;
import com.learning.springboot_mongodb.dto.OfficeAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employeeDetails")
public class Employee {
    @Id
    private String id;
    private String empName;
    private String designation;
    private HomeAddress homeAddress;
    private OfficeAddress officeAddress;
}
