package com.learning.springboot_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeAddress {
    @Id
    private String buildingNo;
    private String companyName;
    private String floor;
    private String area;
    private String town;
    private String state;
    private String country;
    private String postalCode;
}
