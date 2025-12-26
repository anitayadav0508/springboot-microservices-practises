package com.mappings.onetomany.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Integer rollno;
    private String name;
    private Integer marks;

    /* One Student can purchase multiple laptop
    * */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinColumn(name = "stud_lappi", referencedColumnName = "rollno")
    List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Integer getMarks() {
        return marks;
    }

    public Integer getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
