package com.springboot.transcations.with.rollback.service;

import com.springboot.transcations.with.rollback.entity.Employee;
import com.springboot.transcations.with.rollback.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public void  saveEmployeeRecord() {
        Employee employee = new Employee();
        employee.setEmpId(202);
        employee.setEmployeeName("Alisha");
        employee.setEmpSalary(50000l);
       employeeRepository.save(employee);
    }
}
