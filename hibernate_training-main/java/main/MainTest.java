package main;

import model.Employee;
import persistence.RepositoryEmployee;

import java.util.Date;

public class MainTest {
    public static void main(String[] args) {
        RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
        /*
        Employee employee = new Employee();
        employee.setFirstName("Mike");
        employee.setLastName("Charming");
        employee.setEmail("mike@charming.com");
        employee.setPhoneNumber("66666666");
        employee.setSalary(5000);
        employee.setDateOfBirth(new Date());
        employee.setEmployeeId(2);

        repositoryEmployee.saveEmployee(employee);
        repositoryEmployee.deleteEmployee(employee);

        repositoryEmployee.listAllEmployees().forEach(employee1 -> System.out.println(employee1.toString()));

        repositoryEmployee.findEmployeeByFirstNameAndLastName("Mike", "Charming").forEach(e -> System.out.println(e.toString()));

        repositoryEmployee.updateSalaryByPercent(10);
        repositoryEmployee.listAllEmployees().forEach(employee1 -> System.out.println(employee1.toString()));
        repositoryEmployee.listEmployeesWithDepartmentName().forEach(e -> System.out.println(e.toString()));
        */
    }
}
