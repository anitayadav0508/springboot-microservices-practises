package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
