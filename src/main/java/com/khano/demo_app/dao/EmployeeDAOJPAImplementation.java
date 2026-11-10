package com.khano.demo_app.dao;

import com.khano.demo_app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImplementation implements EmployeeDAO{


    // set up a field for entity manager
    private EntityManager entityManager;

    // set up a constructor
    @Autowired
    public EmployeeDAOJPAImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get results
        List<Employee> employees = theQuery.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

//    @Override
//    public Employee getEmployeeById(int employeeId) {
//        return entityManager.find(Employee.class, employeeId);
//    }
}
