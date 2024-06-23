package com.acme.employeemanagementsystem.runner;

import com.acme.employeemanagementsystem.exception.InvalidSalaryIncreaseToOutsourcedEmployeeException;
import com.acme.employeemanagementsystem.model.Employee;
import com.acme.employeemanagementsystem.model.Level;
import com.acme.employeemanagementsystem.model.OutsourcedEmployee;
import com.acme.employeemanagementsystem.repository.EmployeeRepository;
import com.acme.employeemanagementsystem.repository.EmployeeRepositoryImpl;
import com.acme.employeemanagementsystem.service.EmployeeService;
import com.acme.employeemanagementsystem.service.EmployeeServiceImpl;
import com.acme.employeemanagementsystem.service.OutsourcedEmployeeServiceImpl;
import com.acme.employeemanagementsystem.service.PayRiseService;
import com.acme.employeemanagementsystem.service.PayRiseServiceImpl;
import com.acme.employeemanagementsystem.service.RandomEmployeeDataServiceImpl;
import com.acme.employeemanagementsystem.service.RandomOutsourcedEmployeeDataServiceImpl;
import com.acme.employeemanagementsystem.service.RandomSingleton;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Runner {

    public static final double MIN_SALARY_INCREASE = 1.5;
    public static final int MAX_SALARY_INCREASE = 36;

    private static EmployeeService<Employee> employeeService;

    private static EmployeeService<OutsourcedEmployee> outsourcedEmployeeService;
    private static PayRiseService payRiseService;


    private static final List<Employee> employees = new ArrayList<>();
    private static final List<OutsourcedEmployee> outsourcedEmployees = new ArrayList<>();


    public static void main(String[] args) {
        instantiateAllServices();

        populateEmployees();
        populateOutsourcedEmployees();

        riseSalariesToEmployees();
        tryToRiseSalariesToOutsourcedEmployees();

        var intern = employeeService.generateRandomEmployee();
        intern.setLevel(Level.INTERN);
        employees.add(intern);

        log.info("Employee list size %d".formatted(employees.size()));
        employeeService.filterOnlyNotInters(employees);
        log.info("New Employee list size %d".formatted(employees.size()));

    }

    private static void riseSalariesToEmployees() {

        for (Employee employee : employees) {
            payRiseService.increaseSalary(
                employee,
                RandomSingleton.getInstance().getBigDecimal(MIN_SALARY_INCREASE, MAX_SALARY_INCREASE));
            employeeService.save(employee);
        }
    }

    private static void tryToRiseSalariesToOutsourcedEmployees() {

        for (OutsourcedEmployee employee : outsourcedEmployees) {
            try {
                payRiseService.increaseSalary(
                    employee,
                    RandomSingleton.getInstance().getBigDecimal(MIN_SALARY_INCREASE, MAX_SALARY_INCREASE));
                employeeService.save(employee);
            } catch (InvalidSalaryIncreaseToOutsourcedEmployeeException e) {
                log.error(e.getMessage());
            }
        }
    }

    private static void populateEmployees() {
        for(int i = 0; i < RandomSingleton.getInstance().getInt(1, 100); i++){
            employees.add(employeeService.generateRandomEmployee());
        }
    }

    private static void populateOutsourcedEmployees() {
        for(int i = 0; i < RandomSingleton.getInstance().getInt(1, 100); i++){
            outsourcedEmployees.add(outsourcedEmployeeService.generateRandomEmployee());
        }
    }

    private static void instantiateAllServices() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        employeeService = new EmployeeServiceImpl(employeeRepository, new RandomEmployeeDataServiceImpl());
        outsourcedEmployeeService = new OutsourcedEmployeeServiceImpl(employeeRepository, new RandomOutsourcedEmployeeDataServiceImpl());
        payRiseService = new PayRiseServiceImpl();
    }

}
