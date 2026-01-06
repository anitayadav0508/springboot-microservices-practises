package com.example.implement.many.to.many.employee.entity.with.project.employee.entity;

import com.example.implement.many.to.many.employee.entity.with.project.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMP_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    /*This is owning entity*/

    @ManyToMany
    @JoinTable(name = "employee_project",

             joinColumns =  @JoinColumn(name = "employee_id",referencedColumnName = "empId"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "projectId")
    )
    private Set<Project> assignedProjects = new HashSet<>();

}
