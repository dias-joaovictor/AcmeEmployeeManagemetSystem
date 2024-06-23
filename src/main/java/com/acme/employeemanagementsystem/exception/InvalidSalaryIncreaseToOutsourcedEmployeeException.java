package com.acme.employeemanagementsystem.exception;

import com.acme.employeemanagementsystem.model.OutsourcedEmployee;

public class InvalidSalaryIncreaseToOutsourcedEmployeeException extends RuntimeException {
    private static final String MESSAGE = "Impossible to rise employee's salary because this employee is outsourced" +
        ". Employee %s working for %s";

    public InvalidSalaryIncreaseToOutsourcedEmployeeException(OutsourcedEmployee employee) {
        super(MESSAGE.formatted(employee.getName(), employee.getOutsourcingCompany()));
    }
}
