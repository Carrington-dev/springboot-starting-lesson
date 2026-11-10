package com.khano.demo_app.dao;

import com.khano.demo_app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

//    Employee getEmployeeById(int );
}
