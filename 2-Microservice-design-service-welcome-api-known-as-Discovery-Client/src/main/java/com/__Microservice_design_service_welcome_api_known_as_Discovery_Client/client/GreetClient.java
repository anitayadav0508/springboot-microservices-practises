package com.__Microservice_design_service_welcome_api_known_as_Discovery_Client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/*It is acting as a client for GREET-API*/

@FeignClient(name = "GREET-API-02")
public interface GreetClient {

    @GetMapping("/greet")
    public String invokeGreetApi();
}

/*I have created an interface and for this interface i have specified one annotation called @FeignClient(name="GREET-API")
* and i have specifices  this client class is communicate to which rest-api for which api it is acting as client i have configure that.And i have written  a method what request we need to send this
* GREET-API , I have specified by using GetMapping annotation it means we need to send Get request with the slash greet (i.e /greet), /greet is the url pattern  */
