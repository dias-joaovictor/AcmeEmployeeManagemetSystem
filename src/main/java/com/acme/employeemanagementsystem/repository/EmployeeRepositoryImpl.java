package com.acme.employeemanagementsystem.repository;

import com.acme.employeemanagementsystem.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * Very fake implementation since database access is out of scope.
 */
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public void save(Employee employee) {
        log.info("Employee {} successfully saved", employee);
    }

    @Override
    public void delete(Employee employee) {
        log.info("Employee {} successfully deleted", employee);
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }
}
