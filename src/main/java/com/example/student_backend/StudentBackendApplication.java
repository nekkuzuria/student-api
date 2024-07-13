package com.example.student_backend;

import com.example.student_backend.model.Student;
import com.example.student_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class StudentBackendApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(StudentBackendApplication.class, args);
	}

	// Attribute
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
