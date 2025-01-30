package com.example.project2.service;


import com.example.project2.entity.Department;
import com.example.project2.repository.DepartmentRepository;
import com.example.project2.service.DepartmentService;
import com.example.project2.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final LoggingService loggingService;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, LoggingService loggingService) {
        this.departmentRepository = departmentRepository;
        this.loggingService = loggingService;
    }

    @Override
    public Department addDepartment(Department department) {
        loggingService.log("Adding new department: " + department.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        loggingService.log("Fetching department with ID: " + id);
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        loggingService.log("Fetching all departments");
        return departmentRepository.findAll();
    }
}
