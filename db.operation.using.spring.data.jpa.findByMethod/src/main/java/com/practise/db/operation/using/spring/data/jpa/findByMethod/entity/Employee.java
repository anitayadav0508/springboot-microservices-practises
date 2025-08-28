package com.practise.db.operation.using.spring.data.jpa.findByMethod.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee_tbl")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private Long empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name = "emp_sal")
    private  Double empSalary;
}
