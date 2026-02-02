package com.employee.employeemanagement.service;

import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.entity.Hrbp;
import com.employee.employeemanagement.entity.Intern;
import com.employee.employeemanagement.entity.Manager;
import com.employee.employeemanagement.repository.EmployeeRepository;
import com.employee.employeemanagement.repository.HrbpRepository;
import com.employee.employeemanagement.repository.InternRepository;
import com.employee.employeemanagement.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private HrbpRepository hrbpRepository;

    @Autowired
    private InternRepository internRepository;

    @Transactional
    public Intern createIntern(Employee employee, Double stipend, Integer durationMonth, Long managerId, Long hrbpId) {
        // save employee
        employee.setRole("INTERN");
        Employee savedEmployee = employeeRepository.save(employee);

        // fetch manager
        Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager not found"));

        // fetch hrbp
        Hrbp hrbp = hrbpRepository.findById(hrbpId).orElseThrow(() -> new RuntimeException("Hrbp not found"));

        // create intern
        Intern intern = new Intern();

        intern.setEmployee(savedEmployee);
        intern.setDurationMonths(durationMonth);
        intern.setStipend(stipend);
        intern.setManager(manager);
        intern.setHrbp(hrbp);

        // save intern
        return internRepository.save(intern);
    }
}
