package com.khano.demo_app.rest;

import com.khano.demo_app.dao.EmployeeDAO;
import com.khano.demo_app.entity.Employee;
import com.khano.demo_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class EmployeeController {
    private JsonMapper jsonMapper;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(JsonMapper jsonMapper, EmployeeService employeeService) {
        this.jsonMapper = jsonMapper;
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

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        if (patchPayLoad.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in the request body - " + employeeId);
        }
        Employee patchedEmployee = jsonMapper.updateValue(employee, patchPayLoad);
        return employeeService.save(patchedEmployee);
    }
}
