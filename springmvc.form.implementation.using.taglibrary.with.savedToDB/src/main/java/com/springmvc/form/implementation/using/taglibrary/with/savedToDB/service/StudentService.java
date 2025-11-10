package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.service;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.binding.Student;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Courses;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Gender;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Timings;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories.CourseRepository;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories.GenderRepositoery;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories.StudentRespository;
import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories.TimingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private GenderRepositoery genderRepositoery;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TimingRepository timingRepository;
    @Autowired
    private StudentRespository studentRespository;

    public List<String> getGenders(){
      List<Gender> findAll =  genderRepositoery.findAll();
      List<String> genders = new ArrayList<>();

      findAll.forEach(gender -> {
          genders.add(gender.getGenderName());
      });
      return genders;
    }

    public List<String> getCourses(){
      List<Courses> findAll = courseRepository.findAll();
      List<String> courses = new ArrayList<>();
      findAll.forEach(course -> {
        courses.add(course.getCourseName());
      });
      return courses;
    }

    public List<String> getTimings(){
      List<Timings> findAll = timingRepository.findAll();
      List<String> timings = new ArrayList<>();
      findAll.forEach(timing -> {
        timings.add(timing.getTimingName());
      });
      return timings;
     
    }

    public void saveFormData(Student student){
        studentRespository.save(student);

    }
}
