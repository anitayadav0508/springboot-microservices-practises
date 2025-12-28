package com.mapping.relationship.ManyToMany.controller;

import com.mapping.relationship.ManyToMany.entity.Course;
import com.mapping.relationship.ManyToMany.entity.Student;
import com.mapping.relationship.ManyToMany.repository.CourseRepository;
import com.mapping.relationship.ManyToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {


    /*Perform Constructor dependency Injection*/
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentCourseController(StudentRepository studentRepository,CourseRepository courseRepository){

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;

    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }


    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }


    @GetMapping("find/{name}")
    public List<Student> findStudentContainingByName(@PathVariable String name){

        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable Double price){
        return courseRepository.findByFeeLessThan(price);
    }


}
