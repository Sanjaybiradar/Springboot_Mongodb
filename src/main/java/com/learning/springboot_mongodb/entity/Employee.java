package com.learning.springboot_mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userDetails")
public class Employee {
    @Id
    private String id;
    private String empName;
    private String password;
    private boolean isActive;
    private String roles;
    private String dept;
    private String designation;
}
