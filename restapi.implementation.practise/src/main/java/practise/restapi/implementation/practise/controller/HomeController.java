package practise.restapi.implementation.practise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String display(){
        return "Welcome to my First Project!!";
    }
}
