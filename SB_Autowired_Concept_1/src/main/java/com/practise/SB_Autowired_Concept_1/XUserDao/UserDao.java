package com.practise.SB_Autowired_Concept_1.XUserDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    UserDao(){
        System.out.println("----------Represent UserDao as spring " +
                "bean class with the help of @Repository annotation so IOC will create object for UserDao class " +
                "and its object created when it refer inside userservice constructor because target/dependent object created" +
                "first although scanning of userService package perform  first-----------");
    }

    public boolean saveUser(String uname,String email){
        System.out.println("--------User data saved at presistent layer successfully----------");
        return true;
    }
}
