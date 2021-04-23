package persistence;

import model.Employee;
import model.EmployeeDepartment;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployee {
    private EntityManager entityManager;

    public RepositoryEmployee(){
        entityManager = DBUtil.getEntityManager();
    }

    public void saveEmployee(Employee employee){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void updateEmployee(Employee employee){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteEmployee(Employee employee){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(employee));
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Employee> listAllEmployees(){
        //Selects all from Object Employee, not table = sql SELECT * FROM Employee
        String sql = "FROM Employee";

        return entityManager.createQuery(sql).getResultList();
    }

    public Employee findEmployeeById(int employeeId){
        String sql = "FROM Employee E WHERE E.employeeId = :id";

        return entityManager.createQuery(sql, Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult();
    }

    /**
     * This method can find only by Primary Key, that is why you can use it to find by Id
     **/

    public Employee findEmployeeByIdAnotherExample(int id){
        return entityManager.find(Employee.class, id);
    }

    public void updateSalaryByPercent(int percent){
        String sql = "UPDATE Employee e SET e.salary = e.salary + ((e.salary * :percent) / 100) WHERE e.salary < 8000";

        entityManager.getTransaction().begin();
        entityManager.createQuery(sql)
                .setParameter("percent", percent)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName){
        String sql = "FROM Employee E WHERE firstName = :E.firstN AND E.lastName = :lName";

        return entityManager.createQuery(sql)
                .setParameter("firstN", firstName)
                .setParameter("lName", lastName)
                .getResultList();
    }

    public List<Employee> findEmployeeByDepartment(String department){
        String sql = "FROM Employee e " +
                "WHERE e.department.departmentName = :depName";

        return entityManager.createQuery(sql).getResultList();
    }

    public List<EmployeeDepartment> listEmployeesWithDepartmentName(){
        String sql = "SELECT new model.EmployeeDepartment(e.employeeId, e.firstName, d.name) " +
                "FROM Employee e JOIN e.department d";
        return entityManager.createQuery(sql, EmployeeDepartment.class).getResultList();
    }
}