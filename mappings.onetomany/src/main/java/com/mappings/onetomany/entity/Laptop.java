package com.mappings.onetomany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private Integer id;
    private String lname;


    public Integer getId(){
        return id;
    }

    public String getLname() {
        return lname;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", lname='" + lname + '\'' +
                '}';
    }
}
