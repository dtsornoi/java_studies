package com.example.crud.dao;

import com.example.crud.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession
                .createQuery("delete from Employee where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
