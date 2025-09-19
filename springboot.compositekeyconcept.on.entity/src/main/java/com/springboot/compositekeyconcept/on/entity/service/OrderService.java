package com.springboot.compositekeyconcept.on.entity.service;


import com.springboot.compositekeyconcept.on.entity.entity.Compositekey;
import com.springboot.compositekeyconcept.on.entity.entity.Order;
import com.springboot.compositekeyconcept.on.entity.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }


    public void orderARecord(){
        Order order = new Order();
        order.setOrderName("Face Wash");
        order.setPrice(201);
        order.setQuantity(1);
        Compositekey compositekey = new Compositekey(13,14);
        order.setId(compositekey);

        orderRepository.save(order);
    }
}
