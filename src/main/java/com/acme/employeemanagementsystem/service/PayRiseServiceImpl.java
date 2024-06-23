package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.exception.InvalidSalaryIncreaseToOutsourcedEmployeeException;
import com.acme.employeemanagementsystem.model.Employee;
import com.acme.employeemanagementsystem.model.OutsourcedEmployee;

import java.math.BigDecimal;

public class PayRiseServiceImpl implements PayRiseService {

    @Override
    public void increaseSalary(Employee employee, BigDecimal percentage) {
        if(!isEmployeeValidToIncrease(employee)){
            throw new InvalidSalaryIncreaseToOutsourcedEmployeeException((OutsourcedEmployee) employee);
        }

        employee.setSalary(employee.getSalary().multiply(new BigDecimal(1).add(percentage)));
    }

    @Override
    public boolean isEmployeeValidToIncrease(Employee employee) {
        return !(employee instanceof OutsourcedEmployee);
    }
}
