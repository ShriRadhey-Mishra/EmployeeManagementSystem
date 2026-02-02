package com.employee.employeemanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

    public Manager() {}

    public Manager(String department, Employee employee) {
        this.department = department;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
