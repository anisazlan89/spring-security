package com.springsecurity.login.demo.controller;

import com.springsecurity.login.demo.model.Users;
import com.springsecurity.login.demo.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsersController {

    @Autowired
    usersService usersService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") Users user, BindingResult binding, RedirectAttributes redirectAttributes){
        if (binding.hasErrors() || user.getPwd() == null || user.getPwd().length() < 8) {
            return "register";
        }

        boolean isSaved = usersService.createNewUser(user);

        if (isSaved){
            redirectAttributes.addFlashAttribute("msg", "Registration Successful! Please login.");
            return "redirect:/login?register=true";
        }
        /*binding.reject("save.failed", "Unable to create user");*/
        return "register";
        }

    }






