package com.employee.employeemanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interns")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double stipend;

    private Integer durationMonths;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "hrbp_id")
    private Hrbp hrbp;

    public Intern() {}

    public Intern(Double stipend, Integer durationMonths, Employee employee) {
        this.stipend = stipend;
        this.durationMonths = durationMonths;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public Double getStipend() {
        return stipend;
    }

    public void setStipend(Double stipend) {
        this.stipend = stipend;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Hrbp getHrbp() {
        return hrbp;
    }

    public void setHrbp(Hrbp hrbp) {
        this.hrbp = hrbp;
    }
}
