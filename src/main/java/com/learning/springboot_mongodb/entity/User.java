package com.learning.springboot_mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userDetails")
public class User extends Query {
    @Id
    @NotNull
    private String userId;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
