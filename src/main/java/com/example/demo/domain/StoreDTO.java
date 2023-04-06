package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    private Integer age;
    private String name;
    private String storeName;
    private String address;
    private String openingHour;
    private String closingHour;
}
