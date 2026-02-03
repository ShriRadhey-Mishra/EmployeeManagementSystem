package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByRole(String role) {
        List<Employee> allEmployee = employeeRepository.findAll();

        return allEmployee.stream()
                .filter(emp -> emp.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
