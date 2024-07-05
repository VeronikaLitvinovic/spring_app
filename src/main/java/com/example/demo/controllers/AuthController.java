//package com.example.demo.controllers;
//
//
//import com.example.demo.Dao.UserDAO;
//import com.example.demo.model.User;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AuthController {
//
//    private final UserDAO dao;
//
//    public AuthController(UserDAO dao) {
//        this.dao = dao;
//    }
//
//
////    @PostMapping
////    public Long createUser(@RequestBody User user) {
////        return dao.createUser(user);
////    }
//
////    @GetMapping
////    public User getUserById(@RequestParam Long id) {
////        return dao.getUserById(id);
////    }
//
//    @PostMapping("/createUser")
//    public Long createUser(@RequestBody User user) {
//        return dao.createUser(user);
//    }
//
//    @GetMapping("/getUserById")
//    public User getUserById(@RequestParam Long id) {
//        return dao.getUserById(id);
//    }
//
//}