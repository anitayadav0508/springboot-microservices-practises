package com.springboot.compositekeyconcept.on.entity.repository;

import com.springboot.compositekeyconcept.on.entity.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OrderRepository extends JpaRepository<Order, Serializable> {
}
