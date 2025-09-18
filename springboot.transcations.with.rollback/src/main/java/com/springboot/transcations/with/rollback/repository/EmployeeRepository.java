package com.springboot.transcations.with.rollback.repository;

import com.springboot.transcations.with.rollback.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {
}
