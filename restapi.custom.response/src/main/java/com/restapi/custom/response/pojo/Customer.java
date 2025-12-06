package com.restapi.custom.response.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private Integer customerId;
    private String customerName;
    private Integer customerPhoneNo;


    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhoneNo(Integer customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }


}
