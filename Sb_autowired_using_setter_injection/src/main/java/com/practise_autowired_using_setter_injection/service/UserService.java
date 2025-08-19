package com.practise_autowired_using_setter_injection.service;

import com.practise_autowired_using_setter_injection.dao.UserDao;
import com.practise_autowired_using_setter_injection.utils.EmailUtil;
import com.practise_autowired_using_setter_injection.utils.PwdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {  //target bean class

    UserService(){
        System.out.println("---------Using 0-params constructor IOC create its object " +
                "Represent UserService as spring bean due to @Service annotation ");
    }



    private PwdUtil pwdUtil;
    private EmailUtil emailUtil;
    private UserDao userDao;


    @Autowired
    //known as setter injection
    public void setEmailUtil(EmailUtil emailUtil) { //target bean setter method and EmailUtil is dependent bean
        this.emailUtil = emailUtil;
    }

    @Autowired
    //known as setter injection
    public void setPwdUtil(PwdUtil pwdUtil) { //target bean  setter method and PwdUtil is dependent bean
        this.pwdUtil = pwdUtil;
    }

    @Autowired
        //known as constructor injection
    UserService(UserDao userDao){
        System.out.println("---------Using 1-params constructor IOC create its object " +
                "Represent UserService as spring bean due to @Service annotation ");
        this.userDao = userDao;
    }


    public void registerUser(){
        this.pwdUtil.encryptPassword("anita@1234");
        this.userDao.saveUser();
        this.emailUtil.sendEmail("alishayadav0508@gmail.com");
    }
}
