package com.restapi.custom.response.pojo;

public class User {
    private Integer uid;
    private String fname;
    private String lname;
    private String email;


    public User(){
        System.out.println("User Constructor::");
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public Integer getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
