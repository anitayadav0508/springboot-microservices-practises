package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.binding;

import jakarta.persistence.*;

/* this is our binding class which is use to bind formdata*/
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phno")
    private Long phno;

    @Column(name = "gender")
    private String gender;

    @Column(name = "course")
    private String course;

    @Column(name = "timings", length = 1000)
    private String timings;

    @Transient
    private String[] timingsArray;

    @PostLoad
    private void postLoad() {
        // Convert String timings to String[] when loading from database
        if (timings != null && !timings.isEmpty()) {
            this.timingsArray = timings.split(",");
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // For form binding - returns String array
    public String[] getTimings() {
        if (timingsArray != null) {
            return timingsArray;
        }
        if (timings != null && !timings.isEmpty()) {
            return timings.split(",");
        }
        return new String[0];
    }

    // For form binding - accepts String array
    public void setTimings(String[] timingsArray) {
        this.timingsArray = timingsArray;
        if (timingsArray != null && timingsArray.length > 0) {
            this.timings = String.join(",", timingsArray);
        } else {
            this.timings = null;
        }
    }

    // For database storage - returns String
    public String getTimingsString() {
        return timings;
    }

    // For database storage - accepts String
    public void setTimingsString(String timings) {
        this.timings = timings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
