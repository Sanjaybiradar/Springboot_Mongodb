package com.learning.springboot_mongodb.entity;

import com.learning.springboot_mongodb.dto.HomeAddress;
import com.learning.springboot_mongodb.dto.OfficeAddress;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection = "EmployeeDetails")
public class Employee {
    @Id
    @NonNull
    private String id;
    @NonNull
    private String empName;
    @NonNull
    private String designation;
    @NonNull
    private HomeAddress homeAddress;
    @NonNull
    private OfficeAddress officeAddress;

}
