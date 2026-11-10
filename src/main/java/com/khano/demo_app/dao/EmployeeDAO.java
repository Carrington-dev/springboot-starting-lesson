package com.khano.demo_app.dao;

import com.khano.demo_app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int employeeId);

//    Employee getEmployeeById(int );
}
