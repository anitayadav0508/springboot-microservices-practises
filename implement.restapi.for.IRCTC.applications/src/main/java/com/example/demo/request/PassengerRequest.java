package com.example.demo.request;

import jakarta.xml.bind.annotation.XmlRootElement;

// this class can take data in xml/json any one of them format
//RequestBinding class
@XmlRootElement
public class PassengerRequest {
    private String name;
    private String dob;
    private String gender;
    private String doj;
    private String from;
    private String to;
    private String train;

    // Default constructor
    public PassengerRequest() {
    }

    // Parameterized constructor
    public PassengerRequest(String name, String dob, String gender, String doj, String from, String to, String train) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.doj = doj;
        this.from = from;
        this.to = to;
        this.train = train;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getDoj() {
        return doj;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTrain() {
        return train;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    // toString
    @Override
    public String toString() {
        return "PassengerRequest{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", doj='" + doj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", train='" + train + '\'' +
                '}';
    }
}
