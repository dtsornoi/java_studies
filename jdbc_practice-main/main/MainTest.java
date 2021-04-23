package main;

import model.Employees;
import persistence.RepositoryEmployees;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
//        Employees employee1 = new Employees();
//        employee1.setFirstName("Josh");
//        employee1.setLastName("Charming");
//        employee1.setDateOfBirth("1990-01-01");
//        employee1.setPhone("44444444");
//        employee1.setEmail("josh.charming@test.com");
//        employee1.setSalary(5000);
//        employee1.setEmployeeId(1);

        RepositoryEmployees repositoryEmployees = new RepositoryEmployees();
//        repositoryEmployees.saveEmployee(employee1);
//        repositoryEmployees.updateEmployee(employee1);
//        repositoryEmployees.deleteEmployee(employee1);
//        Employees result = repositoryEmployees.findEmployeeById(2);
//        System.out.println(result.toString());
//        System.out.println(repositoryEmployees.findEmployeeByFirstName("Sofie").toString());
            List<Employees> result = repositoryEmployees.findAllEmployees();

            for (Employees employee : result){
                System.out.println(employee.toString());
            }
    }
}
