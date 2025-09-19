package com.springboot.compositekeyconcept.on.entity.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Compositekey implements Serializable {

    private Integer orderId;
    private Integer productId;


    public Compositekey() {
    }


    public Compositekey(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compositekey)) return false;
        Compositekey other = (Compositekey) o;
        return Objects.equals(orderId, other.orderId) &&
                Objects.equals(productId, other.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
