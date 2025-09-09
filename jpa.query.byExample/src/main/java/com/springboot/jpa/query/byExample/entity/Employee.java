package com.springboot.jpa.query.byExample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    public Integer empId;

    @Column(name = "employee_name")
    public String empName;

    @Column(name = "employee_location")
    public String employeeLoc;

    @Column(name = "designation")
    public String designation;

    @Column(name = "projectName")
    public String projectName;

}
