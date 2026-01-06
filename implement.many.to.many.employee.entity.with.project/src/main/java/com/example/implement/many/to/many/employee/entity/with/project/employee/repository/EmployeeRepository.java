package com.example.implement.many.to.many.employee.entity.with.project.employee.repository;

import com.example.implement.many.to.many.employee.entity.with.project.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByEmpId(Long empId);
}
