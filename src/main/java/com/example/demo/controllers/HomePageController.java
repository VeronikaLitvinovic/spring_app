package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHomePage(Model model) {
        return "homePage";
    }

//    @GetMapping("/login")
//    public String showLoginPage(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/registration")
//    public String showRegPage(Model model) {
//        return "registration";
//    }

}