package com.springboot_springwebmvc_implementation_using_jsp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Product {

    private String name;
    private Integer productId;
    private Double price;

    public Product(){

    }

    public Product(String name,Integer productId,Double price){
        this.name  = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName(){
        return name;
    }

    public Integer getProductId(){
        return productId;
    }

    public Double getPrice(){
        return  price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}
