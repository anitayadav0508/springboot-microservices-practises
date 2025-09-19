package com.springboot.compositekeyconcept.on.entity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private Compositekey id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    public Order() {
    }


    public Order(Compositekey id, String orderName, Integer quantity, Integer price) {
        this.id = id;
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
    }


    public Compositekey getId() {
        return id;
    }

    public void setId(Compositekey id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
