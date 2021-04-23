package model;

public class EmployeesProjects {
    private int employeeProjectId;
    private int employeeId;
    private int projectId;

    public int getEmployeeProjectId() {
        return employeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "EmployeesProjects{" +
                "employeeProjectId=" + employeeProjectId +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
