package com.practise.springboot_1.userService;


import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserService(){
        System.out.println("---Represent UserService class as spring bean class with the help of @Service annotation");
    }
}
