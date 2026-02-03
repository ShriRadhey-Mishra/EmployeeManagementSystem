package com.employee.employeemanagement.controller;

import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/interns")
    public List<Employee> getAllInterns() {
        return employeeService.getEmployeeByRole("INTERN");
    }

    @GetMapping("/managers")
    public List<Employee> getAllManagers() {
        return employeeService.getEmployeeByRole("MANAGER");
    }

    @GetMapping("/hrs")
    public List<Employee> getAllHrs() {
        return employeeService.getEmployeeByRole("HR");
    }

    @GetMapping("/staff")
    public List<Employee> getAllStaffs() {
        return employeeService.getEmployeeByRole("STAFF");
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/id")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "deleted Employee "+id+" successfully";
    }

}
