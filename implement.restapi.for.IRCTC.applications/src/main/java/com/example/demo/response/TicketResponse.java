package com.example.demo.response;

import jakarta.xml.bind.annotation.XmlRootElement;

//ResponseBinding class
@XmlRootElement
public class TicketResponse {

    private String pnr;      // Unique PNR number for ticket identification
    private String name;
    private String dob;
    private String gender;
    private String doj;
    private String from;
    private String to;
    private String train;
    private String status;
    private Float price;

    // Default constructor
    public TicketResponse() {
    }

    // Parameterized constructor
    public TicketResponse(String name, String dob, String gender, String doj, String from, String to, String train, String status, Float price) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.doj = doj;
        this.from = from;
        this.to = to;
        this.train = train;
        this.status = status;
        this.price = price;
    }

    // Getters
    public String getPnr() {
        return pnr;
    }

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

    public String getStatus() {
        return status;
    }

    public Float getPrice() {
        return price;
    }

    // Setters
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "TicketResponse{" +
                "pnr='" + pnr + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", doj='" + doj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", train='" + train + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
