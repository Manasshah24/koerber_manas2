package com.example.mongo_crud.service;

import com.example.mongo_crud.model.Student;
import com.example.mongo_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a student by ID
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update a student
    public Student updateStudent(String id, Student studentDetails) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }

    // Delete a student
    public String deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted successfully.";
        } else {
            return "Student not found.";
        }
    }
}

