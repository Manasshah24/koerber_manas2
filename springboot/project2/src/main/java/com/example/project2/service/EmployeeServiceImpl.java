package com.example.project2.service;


import com.example.project2.entity.Employee;
import com.example.project2.repository.EmployeeRepository;
import com.example.project2.service.EmployeeService;
import com.example.project2.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LoggingService loggingService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, LoggingService loggingService) {
        this.employeeRepository = employeeRepository;
        this.loggingService = loggingService;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        loggingService.log("Adding new employee: " + employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        loggingService.log("Fetching employee with ID: " + id);
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        loggingService.log("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        loggingService.log("Fetching employees from department ID: " + departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> getEmployeesWithHighSalary(double salary) {
        loggingService.log("Fetching employees with salary greater than: " + salary);
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Override
    public void deleteEmployee(Long id) {
        loggingService.log("Deleting employee with ID: " + id);
        employeeRepository.deleteById(id);
    }
}
