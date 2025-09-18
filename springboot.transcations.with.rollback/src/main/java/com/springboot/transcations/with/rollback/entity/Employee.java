package com.springboot.transcations.with.rollback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "employee_tbl")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private String employeeName;
    @Column(name = "emp_sal")
    private Long empSalary;

}
