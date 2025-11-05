package com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.controller;

import com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.pojo.Product;
import com.springboot.webmvc.passing.data.by.differentway.from.UI.to.Server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductTagLibraryController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/defaultForm","/displayForm"})
    public String loadForm(Model model){
        Product proudct = new Product();

        model.addAttribute("product",proudct);
        return "default";

    }

    @PostMapping("/saveProductDetails")
    public String saveProductDetails(Product product ,Model model){
        System.out.println("Product details which enter to form " +  product);

        try {
            productService.saveProductDetailsToDb(product);
            model.addAttribute("msg","Saved to catalog successfully");
            return "saved";
        } catch (Exception e) {
            System.err.println("Error in controller while saving product: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("msg","Error saving product: " + e.getMessage());
            return "saved";
        }

    }

}
