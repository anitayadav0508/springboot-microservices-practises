package com.spring.boot.validation_mvc_project.binding;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
    @NotEmpty(message = "Please enter username")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String uname;
    @NotEmpty(message = "Please enter password")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$", message = "Password must be at least 8 characters long, contain at least one capital letter and one special character")
    private String pwd;
    @NotEmpty(message = "Please enter email")
    @Email(message = "Please enter valid email")
    private String email;
    @NotNull(message = "Please enter phoneNumber")
    @Digits(integer = 10, fraction = 0, message = "PhoneNumber must be 10 long digits")
    private Long phno;

    public Long getPhno() {
        return phno;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phno=" + phno +
                '}';
    }

}
