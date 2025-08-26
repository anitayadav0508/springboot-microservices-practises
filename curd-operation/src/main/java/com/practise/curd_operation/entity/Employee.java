package com.practise.curd_operation.entity;



import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="EMP_TBL")
public class Employee {


    @Id
    @Column(name = "EMP_ID")
    private Integer empId;
    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_SAL")
    private Long empSalary;



}
