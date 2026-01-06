package com.example.implement.many.to.many.employee.entity.with.project.project.entity;

import com.example.implement.many.to.many.employee.entity.with.project.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROJECT_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;

    /* I don't  want to assign duplicate project to same employee */
    // mappedBy :- we have to define that we are mapping this employee set by which property so basically it is assignedProjects
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    Set<Employee> employees =  new HashSet<>();
}
