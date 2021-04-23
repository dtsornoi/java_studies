package persistence;

import model.Employees;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryEmployees {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RepositoryEmployees() {
        connection = DBUtil.getDBConnection();
    }

    public void saveEmployee(Employees employees){

        String sql = "INSERT INTO employees(firstName, lastName, dateOfBirth, phoneNumber, email, salary)"+
                " VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employees.getFirstName());
            preparedStatement.setString(2, employees.getLastName());
            preparedStatement.setDate(3, Date.valueOf(employees.getDateOfBirth()));
            preparedStatement.setString(4, employees.getPhone());
            preparedStatement.setString(5, employees.getEmail());
            preparedStatement.setInt(6, employees.getSalary());

            int result = preparedStatement.executeUpdate();

            if(result > 0) System.out.println("Employee saved to DataBase sda_jdbc");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateEmployee(Employees employees){
        String sql = "UPDATE employees SET firstName = ?, lastName = ?, dateOfBirth = ?, phoneNumber = ?, email = ?, salary = ?"+
                " WHERE employeeID= ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employees.getFirstName());
            preparedStatement.setString(2, employees.getLastName());
            preparedStatement.setDate(3, Date.valueOf(employees.getDateOfBirth()));
            preparedStatement.setString(4, employees.getPhone());
            preparedStatement.setString(5, employees.getEmail());
            preparedStatement.setInt(6, employees.getSalary());
            preparedStatement.setInt(7, employees.getEmployeeId());

            int result = preparedStatement.executeUpdate();

            if(result > 0) System.out.println("Employee with "+ employees.getEmployeeId() + " updated  on DataBase sda_jdbc");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void  deleteEmployee(Employees employees){
        String sql = "DELETE FROM employees WHERE employeeID= ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employees.getEmployeeId());

            int result = preparedStatement.executeUpdate();

            if(result > 0) System.out.println("Employee with "+ employees.getEmployeeId() + " was deleted on DataBase sda_jdbc");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Employees findEmployeeById(int employeeId){
        Employees employeesResult = null;
        String sql = "SELECT * FROM employees WHERE employeeId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employeesResult = new Employees();
                employeesResult.setFirstName(resultSet.getString("firstName"));
                employeesResult.setLastName(resultSet.getString("lastName"));
                Date date = resultSet.getDate("dateOfBirth");
                employeesResult.setDateOfBirth(date.toString());
                employeesResult.setPhone(resultSet.getString("phoneNumber"));
                employeesResult.setEmail(resultSet.getString("email"));
                employeesResult.setSalary(resultSet.getInt("salary"));
                employeesResult.setEmployeeId(resultSet.getInt("employeeId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesResult;
    }

    public Employees findEmployeeByFirstName(String employeeFirstName){
        Employees employeesResult = null;
        String sql = "SELECT * FROM employees WHERE firstName = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeFirstName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employeesResult = new Employees();
                employeesResult.setFirstName(resultSet.getString("firstName"));
                employeesResult.setLastName(resultSet.getString("lastName"));
                Date date = resultSet.getDate("dateOfBirth");
                employeesResult.setDateOfBirth(date.toString());
                employeesResult.setPhone(resultSet.getString("phoneNumber"));
                employeesResult.setEmail(resultSet.getString("email"));
                employeesResult.setSalary(resultSet.getInt("salary"));
                employeesResult.setEmployeeId(resultSet.getInt("employeeId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesResult;
    }

    public List<Employees> findAllEmployees(){
        List<Employees> listOfEmployees = new ArrayList<>();
        Employees employeesResult = null;

        String sql = "SELECT * FROM employees";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employeesResult = new Employees();
                employeesResult.setFirstName(resultSet.getString("firstName"));
                employeesResult.setLastName(resultSet.getString("lastName"));
                Date date = resultSet.getDate("dateOfBirth");
                employeesResult.setDateOfBirth(date.toString());
                employeesResult.setPhone(resultSet.getString("phoneNumber"));
                employeesResult.setEmail(resultSet.getString("email"));
                employeesResult.setSalary(resultSet.getInt("salary"));
                employeesResult.setEmployeeId(resultSet.getInt("employeeId"));

                listOfEmployees.add(employeesResult);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOfEmployees;
    }
}
