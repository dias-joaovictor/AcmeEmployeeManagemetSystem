package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Employee;

import java.math.BigDecimal;

public interface PayRiseService {

    void increaseSalary(Employee employee, BigDecimal percentage);

    boolean isEmployeeValidToIncrease(Employee employee);

}
