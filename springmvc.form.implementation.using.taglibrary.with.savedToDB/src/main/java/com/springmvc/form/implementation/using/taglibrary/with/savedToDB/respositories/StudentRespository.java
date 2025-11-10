package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.binding.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student,Long> {
}
