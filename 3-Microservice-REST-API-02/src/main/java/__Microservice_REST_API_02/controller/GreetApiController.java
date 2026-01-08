package __Microservice_REST_API_02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetApiController {

    @GetMapping("/greet")
    public String greet(){
        return "Welome to REST-API-02!! ";
    }
}
