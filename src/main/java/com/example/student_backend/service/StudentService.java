package com.example.student_backend.service;

import com.example.student_backend.exception.ResourceNotFoundException;
import com.example.student_backend.model.Student;
import com.example.student_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exists with id: " + id));
    }

    public Student saveStudent(Student student) {
        if (student.getId() == null || student.getId().isEmpty()) {
            student.setId(generateNim());
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exists with id: " + id));
        studentRepository.delete(student);
    }

    private String generateNim() {
        long count = studentRepository.count();
        return String.format("%04dUGM", count + 1);
    }
}
