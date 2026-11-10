package com.khano.demo_app.rest;

import com.khano.demo_app.dao.EmployeeDAO;
import com.khano.demo_app.entity.Employee;
import com.khano.demo_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose /employees
//    public String findAll(){
//        return "Hebo Mngane";
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose /employees/id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee employee = employeeService.save(theEmployee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee employee = employeeService.save(theEmployee);
        return employee;
    }
}
