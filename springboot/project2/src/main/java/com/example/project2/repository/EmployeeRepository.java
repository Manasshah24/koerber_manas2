package com.example.project2.repository;


import com.example.project2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom Query Methods
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findBySalaryGreaterThan(double salary);
}
