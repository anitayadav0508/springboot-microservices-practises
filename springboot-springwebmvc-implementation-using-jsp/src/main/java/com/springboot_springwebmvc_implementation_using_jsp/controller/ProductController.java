package com.springboot_springwebmvc_implementation_using_jsp.controller;


import com.springboot_springwebmvc_implementation_using_jsp.pojo.Product;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {


    @GetMapping("/product")
    public ModelAndView productDetails(){
        ModelAndView mav = new ModelAndView();

        Product product = new Product();
        product.setName("Dove Shampoo");
        product.setProductId(101);
        product.setPrice(550.5);

        mav.addObject("product",product); //adding product obj to model in key-value format

        mav.setViewName("product-detail"); //setting logical view name
        return mav;
    }
}
