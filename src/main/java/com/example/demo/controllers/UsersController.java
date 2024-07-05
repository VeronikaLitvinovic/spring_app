package com.example.demo.controllers;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.mindrot.jbcrypt.BCrypt;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("newUser", new Users());
        return "signUp";
    }

    @PostMapping("/signup")
    public String processSignUp(@Valid @ModelAttribute("newUser") Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
            return "signUp";
        }
        if (user.getUsername().equals("velm")) {
            user.setRole("admin");
        } else {
            user.setRole("user");
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

        usersRepository.save(user);
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("user", new Users());
        return "signIn";
    }

    @PostMapping("/signin")
    public String processSignIn(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            logger.info("Signin form has errors, returning to signin page");
            return "signin";
        }

        Users existingUser = usersRepository.findByUsername(user.getUsername());
        if (existingUser != null && BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
            session.setAttribute("currentUser", existingUser);
            if (existingUser.getRole().equals("admin")) {
                logger.info("Redirecting admin user to /admin");
                return "redirect:/admin";
            } else {
                logger.info("Redirecting user to /accpage");
                return "redirect:/accpage";
            }
        } else {
            bindingResult.rejectValue("password", "error.user", "Invalid username or password");
            logger.info("Invalid credentials, returning to signin page");
            return "signin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/accpage")
    public String userAccountPage(Model model, HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        return "accpage";
    }

    @GetMapping("/admin")
    public String adminAccountPage(Model model, HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        return "admin";
    }

    @GetMapping("/admin/allusers")
    public String adminProfile(Model model) {
        List<Users> allUsers = (List<Users>) usersRepository.findAll();
        model.addAttribute("users", allUsers);
        return "allusers";
    }
}