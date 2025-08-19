package com.practise_autowired_using_setter_injection.service;

import com.practise_autowired_using_setter_injection.dao.UserDao;
import com.practise_autowired_using_setter_injection.utils.EmailUtil;
import com.practise_autowired_using_setter_injection.utils.PwdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserService(){
        System.out.println("---------Using 0-params constructor IOC create its object " +
                "Represent UserService as spring bean due to @Service annotation ");
    }



    private PwdUtil pwdUtil;
    private EmailUtil emailUtil;
    private UserDao userDao;


    @Autowired
    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    @Autowired
    public void setPwdUtil(PwdUtil pwdUtil) {
        this.pwdUtil = pwdUtil;
    }

    @Autowired
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
