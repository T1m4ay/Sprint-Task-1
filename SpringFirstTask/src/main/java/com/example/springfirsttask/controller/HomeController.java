package com.example.springfirsttask.controller;

import com.example.springfirsttask.model.Student;
import com.example.springfirsttask.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model){
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studentList", studentList);
        return "index";
    }

    @GetMapping("/add-student")
    public String addStudentPage(){
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student){
        studentRepository.save(student);
        return "redirect:/";
    }

}
