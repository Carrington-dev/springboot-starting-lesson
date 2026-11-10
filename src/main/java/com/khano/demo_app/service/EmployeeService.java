package com.khano.demo_app.service;

import com.khano.demo_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee getEmployeeById(int employeeId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
