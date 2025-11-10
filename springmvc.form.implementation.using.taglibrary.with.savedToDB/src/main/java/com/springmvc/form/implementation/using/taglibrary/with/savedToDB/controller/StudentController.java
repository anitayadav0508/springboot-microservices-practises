package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.controller;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.binding.Student;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/loadForm")
    public String displayForm(Model model){
        model.addAttribute("genders",studentService.getGenders());
        model.addAttribute("courses",studentService.getCourses());
        model.addAttribute("timings",studentService.getTimings());
        Student student = new Student();
        model.addAttribute("student",student);

        return "index";
    }

    @PostMapping("/saveStudent")
    public String handleRegBtnClick(Student student, Model model){
        System.out.println(student);
        this.studentService.saveFormData(student);
        model.addAttribute("student", student);
        return "saved";
    }
}
