package com.learning.springboot_mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.repository.Query;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userDetails")
public class User implements Query {
    @MongoId
    @NotNull
    private String userId;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @Override
    public String value() {
        return null;
    }

    @Override
    public String fields() {
        return null;
    }

    @Override
    public boolean count() {
        return false;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public String sort() {
        return null;
    }

    @Override
    public String collation() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
