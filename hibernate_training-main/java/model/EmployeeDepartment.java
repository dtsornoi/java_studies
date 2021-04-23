package model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartment {
    private int employeeId;
    private String firstName;
    private String department;
}
