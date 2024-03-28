package com.learning.springboot_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeAddress {
    @Id
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
