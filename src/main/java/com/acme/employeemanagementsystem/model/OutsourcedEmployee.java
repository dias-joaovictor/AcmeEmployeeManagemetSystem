package com.acme.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class OutsourcedEmployee extends Employee {
    private OutsourcingCompany outsourcingCompany;
    private LocalDate endOfContract;
}
