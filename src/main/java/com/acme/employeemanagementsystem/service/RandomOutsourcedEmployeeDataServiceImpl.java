package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Address;
import com.acme.employeemanagementsystem.model.Department;
import com.acme.employeemanagementsystem.model.Level;
import com.acme.employeemanagementsystem.model.OutsourcingCompany;
import com.acme.employeemanagementsystem.model.PhoneNumber;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class RandomOutsourcedEmployeeDataServiceImpl extends RandomEmployeeDataServiceImpl implements RandomOutsourcedEmployeeDataService {
    @Override
    public OutsourcingCompany getOutsourcingCompany() {
        return OutsourcingCompany.builder()
            .address(getAddress())
            .name(getFaker().company().name())
            .contacts(getPhoneNumbers())
            .build();
    }

    @Override
    public LocalDate getEndOfContract() {
        return LocalDate.now().plusMonths(RandomSingleton.getInstance().getInt(1, 11));
    }
}
