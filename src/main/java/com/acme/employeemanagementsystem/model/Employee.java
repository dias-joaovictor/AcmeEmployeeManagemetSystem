package com.acme.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class Employee {

    private String name;

    @Builder.Default
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private Address address;
    private BigDecimal salary;
    private Department department;
    private Level level;
}
