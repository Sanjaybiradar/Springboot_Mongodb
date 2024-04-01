package com.learning.springboot_mongodb.entity;

import com.learning.springboot_mongodb.dto.HomeAddress;
import com.learning.springboot_mongodb.dto.OfficeAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employeeDetails")
public class Employee {
    @Id
    @Valid
    private String id;
    @Valid
    private String empName;
    @Valid
    private String designation;
    @Valid
    private HomeAddress homeAddress;
    @Valid
    private OfficeAddress officeAddress;
}
