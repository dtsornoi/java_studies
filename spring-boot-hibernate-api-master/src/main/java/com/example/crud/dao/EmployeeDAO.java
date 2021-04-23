package com.example.crud.dao;

import com.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
