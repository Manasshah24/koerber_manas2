package com.example.project2.service;


import com.example.project2.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
}

