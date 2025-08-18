package com.practise.SB_Autowired_Concept_1.UserService;


import com.practise.SB_Autowired_Concept_1.UserDao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    UserService(UserDao userDao){
        System.out.println("------Represent userservice as spring bean using @Service annotation---");

        /*Performing Dependency injection with the help of constructor injection*/
        this.userDao = userDao;


    }

    public void getRegisterUser(){
      Boolean isSaved = userDao.saveUser("anita","alishayadav0508@gmail.com");
      if(isSaved){
          System.out.println("save user sucessfully");
      }else{
          System.out.println("not able to save user!!");
      }
    }
}
