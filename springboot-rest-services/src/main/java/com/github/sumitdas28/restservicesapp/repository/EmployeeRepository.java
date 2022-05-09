package com.github.sumitdas28.restservicesapp.repository;

import com.github.sumitdas28.restservicesapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
