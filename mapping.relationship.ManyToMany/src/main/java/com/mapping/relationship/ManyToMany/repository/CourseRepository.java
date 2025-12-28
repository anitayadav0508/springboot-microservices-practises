package com.mapping.relationship.ManyToMany.repository;

import com.mapping.relationship.ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByFeeLessThan(Double fee);
}
