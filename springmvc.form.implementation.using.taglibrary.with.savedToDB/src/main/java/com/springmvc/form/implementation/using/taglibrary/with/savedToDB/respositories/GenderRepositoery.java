package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepositoery extends JpaRepository<Gender,Integer> {
}
