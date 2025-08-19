package com.practise.SB_Autowired_Concept_1.UserDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    UserDao(){
        System.out.println("----------Represent UserDao as spring " +
                "bean class with the help of @Repository annotation-----------");
    }

    public boolean saveUser(String uname,String email){
        System.out.println("--------User data saved at presistent layer successfully----------");
        return true;
    }
}
