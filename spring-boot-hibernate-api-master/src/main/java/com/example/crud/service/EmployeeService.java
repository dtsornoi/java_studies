package com.example.crud.service;

import com.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

}
