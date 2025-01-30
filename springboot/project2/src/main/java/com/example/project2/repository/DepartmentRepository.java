package com.example.project2.repository;


import com.example.project2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Custom Query Methods
    Department findByName(String name);
}
