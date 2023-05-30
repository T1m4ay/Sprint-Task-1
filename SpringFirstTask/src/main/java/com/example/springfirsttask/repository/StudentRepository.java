package com.example.springfirsttask.repository;

import com.example.springfirsttask.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}