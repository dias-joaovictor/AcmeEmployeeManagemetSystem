package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Employee;
import com.acme.employeemanagementsystem.model.OutsourcedEmployee;
import com.acme.employeemanagementsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OutsourcedEmployeeServiceImpl implements EmployeeService<OutsourcedEmployee> {
    private final EmployeeRepository employeeRepository;

    private final RandomOutsourcedEmployeeDataService randomOutsourcedEmployeeDataService;

    // Proxy
    @Override
    public void save(OutsourcedEmployee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public OutsourcedEmployee generateRandomEmployee() {
        return OutsourcedEmployee.builder()
            .name(randomOutsourcedEmployeeDataService.getName())
            .address(randomOutsourcedEmployeeDataService.getAddress())
            .level(randomOutsourcedEmployeeDataService.getLevel())
            .salary(randomOutsourcedEmployeeDataService.getSalary())
            .department(randomOutsourcedEmployeeDataService.getDepartment())
            .phoneNumbers(randomOutsourcedEmployeeDataService.getPhoneNumbers())
            .outsourcingCompany(randomOutsourcedEmployeeDataService.getOutsourcingCompany())
            .endOfContract(randomOutsourcedEmployeeDataService.getEndOfContract())
            .build();
    }

}
