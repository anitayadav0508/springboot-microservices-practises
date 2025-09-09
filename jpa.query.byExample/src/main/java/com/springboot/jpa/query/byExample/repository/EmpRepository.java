package com.springboot.jpa.query.byExample.repository;

import com.springboot.jpa.query.byExample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EmpRepository extends JpaRepository<Employee, Serializable> {
}
