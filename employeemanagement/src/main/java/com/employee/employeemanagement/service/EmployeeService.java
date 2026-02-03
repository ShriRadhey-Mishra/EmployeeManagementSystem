package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
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

    public Employee assignManger(Long employeeId, Long managerId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
        Employee manager = employeeRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager Not Found!"));
        employee.setManager(manager);
        return employeeRepository.save(employee);
    }

    public Employee assignHr(Long employeeId, Long hrId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
        Employee hr = employeeRepository.findById(hrId).orElseThrow(() -> new RuntimeException("HR Not Found!"));
        employee.setHr(hr);
        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getTeamByManager(Long managerId) {
        Employee manager = employeeRepository.findById(managerId).orElseThrow(()-> new RuntimeException("Manager Not Found"));
        return manager.getSubordinate();
    }

}
