package com.employee.employeemanagement.controller;

import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees.stream().filter(emp -> emp.getRole().equalsIgnoreCase("intern")).collect(Collectors.toList());
    }

    @GetMapping("/managers")
    public List<Employee> getAllManagers() {
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees.stream().filter(emp -> emp.getRole().equalsIgnoreCase("manager")).collect(Collectors.toList());
    }

    @GetMapping("/hrs")
    public List<Employee> getAllHrs() {
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees.stream().filter(emp -> emp.getRole().equalsIgnoreCase("hr")).collect(Collectors.toList());
    }

    @GetMapping("/staff")
    public List<Employee> getAllStaffs() {
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return allEmployees.stream().filter(emp -> emp.getRole().equalsIgnoreCase("staff")).collect(Collectors.toList());
    }

    @DeleteMapping("/id")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "deleted Employee "+id+" successfully";
    }

}
