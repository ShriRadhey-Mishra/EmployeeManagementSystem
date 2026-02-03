package com.employee.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required.")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format.")
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    @NotBlank(message = "Role must be assigned.")
    private String role;

    private String department;

    @Positive(message = "Salary must be positive.")
    private Double salary;

    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "hr_id")
    private Employee hr;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
//    @JsonManagedReference
//    @JsonBackReference
    private List<Employee> subordinate;

    public Employee() {}

    public Employee(String name, String email, String phone, String role, LocalDate joiningDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.joiningDate = joiningDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getHr() {
        return hr;
    }

    public void setHr(Employee hr) {
        this.hr = hr;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(List<Employee> subordinate) {
        this.subordinate = subordinate;
    }
}
