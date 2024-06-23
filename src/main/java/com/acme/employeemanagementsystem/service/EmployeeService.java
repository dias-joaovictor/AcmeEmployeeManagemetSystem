package com.acme.employeemanagementsystem.service;

import com.acme.employeemanagementsystem.model.Employee;
import com.acme.employeemanagementsystem.model.Level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface EmployeeService <E extends Employee> {

    void save(E employee);

    E generateRandomEmployee();

    default List<E> filterOnlyNotInters(List<E> employees) {
        Iterator<E> iterator = employees.iterator();

        while (iterator.hasNext()){
            E employee = iterator.next();
            if(employee.getLevel() == Level.INTERN){
                iterator.remove();
            }
        }
        return employees;
    }

}
