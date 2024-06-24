package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.OutsourcingCompany;

import java.time.LocalDate;

public class RandomOutsourcedEmployeeDataServiceImpl extends RandomEmployeeDataServiceImpl implements RandomOutsourcedEmployeeDataService {

    public RandomOutsourcedEmployeeDataServiceImpl(RandomService randomService, FakerService fakerService) {
        super(randomService, fakerService);
    }

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
        return LocalDate.now().plusMonths(randomService.getInt(1, 11));
    }
}
