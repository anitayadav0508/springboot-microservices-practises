package com.restapi.custom.response.controller;

import com.restapi.custom.response.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @PostMapping(value = "/user",consumes = {"application/json","application/xml"},produces = {"text/plain"})
    public String addUser(@RequestBody User user){
        System.out.println(user);

        String msg = "User saved Successfully..";
        return msg;

    }
}
