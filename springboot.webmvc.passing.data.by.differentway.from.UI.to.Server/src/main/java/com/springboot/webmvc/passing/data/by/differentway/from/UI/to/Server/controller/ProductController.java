package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping(value = {"/","/loadForm"})
    public String loadForm(){
        return "index";
    }

    @PostMapping(value = "/saveProduct")
    /*first args capturing data from form using req.getParameter method and second args which is used to send data from controller to view(UI) */
    public String handleSubmitBtn(HttpServletRequest req, Model model){
        //logic to save a form data
         String proudctId =req.getParameter("pid");
         String productName = req.getParameter("pname");
        System.out.println("productId" + proudctId);
        System.out.println("productName" + productName);
        model.addAttribute("msg","Product save to catalog sucessfully!!");
        return "success";
    }
}
