package com.acme.employeemanagementsystem.repository;

import com.acme.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    void delete(Employee employee);

    List<Employee> findAll();
}
