package com.github.novikovmn.interview.controller;

import com.github.novikovmn.interview.domain.Student;
import com.github.novikovmn.interview.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"students","students/"})
public class StudentController {
    @Autowired
    private StudentRepository repository;

    // /interview/students
    @GetMapping({"","/"})
    public String index(Model model) {
        List<Student> students = repository.findAll();
        model.addAttribute("students", students);
        return "index";
    }
}
