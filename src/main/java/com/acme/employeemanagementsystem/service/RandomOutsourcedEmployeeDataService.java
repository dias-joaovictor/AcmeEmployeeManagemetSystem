package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.OutsourcingCompany;

import java.time.LocalDate;

public interface RandomOutsourcedEmployeeDataService extends RandomEmployeeDataService{

    OutsourcingCompany getOutsourcingCompany();
    LocalDate getEndOfContract();
}
