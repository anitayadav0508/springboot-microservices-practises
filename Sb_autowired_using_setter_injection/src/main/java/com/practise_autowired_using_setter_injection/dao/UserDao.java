package com.practise_autowired_using_setter_injection.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    UserDao(){
        System.out.println("---------Using 0-params constructor IOC create its object " +
                "Represent UserDao as spring bean due to @Repository annotation ");
    }

    public void saveUser(){
        System.out.println("User save successfully");
    }
}
