package com.example.project2.service;



import com.example.project2.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByDepartment(Long departmentId);
    List<Employee> getEmployeesWithHighSalary(double salary);
    void deleteEmployee(Long id);
}
