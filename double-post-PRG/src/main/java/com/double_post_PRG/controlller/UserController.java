package com.double_post_PRG.controlller;

import com.double_post_PRG.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping(value = {"/", "createUserAcc"})
    public String loadUserForm(Model model ){

        model.addAttribute("user",new User());
       return "createUserAcc";
    }

    @PostMapping("/createUser")
    /*This method is used to handle user Acc creation Form*/
    public String createUserAcc(RedirectAttributes attributes, User user){

        this.logger.info("User form submitted sucessfully" +  user);
//        model.addAttribute("msg","Account created sucessfully!!");

        attributes.addFlashAttribute("msg","Account created sucessfully!!");
        return "redirect:/userAccCreationSuccess";

    }

    @GetMapping("/userAccCreationSuccess")
    /* This method used to display success msg post registration */
    public String userAccCreationSuccess(Model model){
        this.logger.info("-------------Inside userAccCreationSuccess method-------------------");
        model.addAttribute("user",new User());
        return "createUserAcc";

    }

    /*This is known as PRG post request redirect to get request method*/
}
