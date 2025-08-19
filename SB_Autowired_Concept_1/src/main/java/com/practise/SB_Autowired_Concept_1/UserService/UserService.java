package com.practise.SB_Autowired_Concept_1.UserService;


import com.practise.SB_Autowired_Concept_1.XUserDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService { //userservice act as target class

    private UserDao userDao; //act as dependent bean

    @Autowired
    UserService(UserDao userDao){
        System.out.println("------Represent userservice as spring bean using @Service annotation so IOC will create object" +
                "for this UserService Class---");

        /*Performing Dependency injection with the help of constructor injection*/
        this.userDao = userDao;


    }

    UserService(){
        System.out.println("------------------Default 0-params constructor help IOC for creating UserService object if @Autowired annotation" +
                "is not on parametrized constructor and if @Autowired annotation is their in that case we force IOC use paramerized constructor for object creation------------");
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
