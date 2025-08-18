package com.practise.springboot_1.UserDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    UserDao(){
        System.out.println("---Represent UserDao class as spring bean class with the help of @Repository annotation");
    }


}
