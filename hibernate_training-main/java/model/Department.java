package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Department {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT in MySQL
    private int departmentId;
    private String name;

    //Optional - Bi-Direction
    @OneToMany(mappedBy = "department")
    private List<Employee> employeesList = new ArrayList<>();
}
