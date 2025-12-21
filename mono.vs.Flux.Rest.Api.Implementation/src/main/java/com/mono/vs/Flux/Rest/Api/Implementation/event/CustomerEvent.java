package com.mono.vs.Flux.Rest.Api.Implementation.event;

import java.util.Date;

public class CustomerEvent {
    private String customerName;
    private Date date;

    // Default constructor
    public CustomerEvent() {
    }

    // Parameterized constructor
    public CustomerEvent(String customerName, Date date) {
        this.customerName = customerName;
        this.date = date;
    }

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "customerName='" + customerName + '\'' +
                ", date=" + date +
                '}';
    }
}
