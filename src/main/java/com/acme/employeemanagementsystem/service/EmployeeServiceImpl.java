package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Employee;
import com.acme.employeemanagementsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService<Employee> {
    private final EmployeeRepository employeeRepository;
    private final RandomEmployeeDataService randomEmployeeDataService;

    // Proxy
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee generateRandomEmployee() {
        return Employee.builder()
            .name(randomEmployeeDataService.getName())
            .address(randomEmployeeDataService.getAddress())
            .level(randomEmployeeDataService.getLevel())
            .salary(randomEmployeeDataService.getSalary())
            .department(randomEmployeeDataService.getDepartment())
            .phoneNumbers(randomEmployeeDataService.getPhoneNumbers())
            .build();
    }
}
