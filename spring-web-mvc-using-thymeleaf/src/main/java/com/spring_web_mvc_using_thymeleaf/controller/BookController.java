package com.spring_web_mvc_using_thymeleaf.controller;

import com.spring_web_mvc_using_thymeleaf.binding.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @GetMapping(value = {"/","/addBook"})
    public String loadForm(Model model){
      Book book = new Book();
      model.addAttribute("book",book);
      return "addBook";

    }

    @PostMapping(value = "/addBook")
    public String handleSubmitBtn(Book book){
        System.out.println("book" + book);
        return "bookDtls";
    }
}
