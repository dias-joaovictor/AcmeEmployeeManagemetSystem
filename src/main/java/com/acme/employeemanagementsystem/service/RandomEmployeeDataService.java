package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Address;
import com.acme.employeemanagementsystem.model.Department;
import com.acme.employeemanagementsystem.model.Level;
import com.acme.employeemanagementsystem.model.PhoneNumber;

import java.math.BigDecimal;
import java.util.List;

public interface RandomEmployeeDataService {

    String getName();

    List<PhoneNumber> getPhoneNumbers();

    Address getAddress();

    BigDecimal getSalary();

    Department getDepartment();

    Level getLevel();

}
