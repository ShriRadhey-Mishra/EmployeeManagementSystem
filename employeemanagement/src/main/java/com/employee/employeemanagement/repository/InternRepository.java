package com.employee.employeemanagement.repository;

import com.employee.employeemanagement.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Intern, Long> {
}
