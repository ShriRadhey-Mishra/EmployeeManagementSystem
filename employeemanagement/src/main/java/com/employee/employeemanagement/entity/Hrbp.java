package com.employee.employeemanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hrbps")
public class Hrbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

    @OneToMany(mappedBy = "hrbp")
    private List<Intern> interns;

    public Hrbp() {}

    public Hrbp(String region, Employee employee) {
        this.region = region;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
