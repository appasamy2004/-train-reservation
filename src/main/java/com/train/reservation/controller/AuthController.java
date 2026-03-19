package com.train.reservation.controller;

import com.train.reservation.model.User;
import com.train.reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {
        String msg = userService.register(user);
        model.addAttribute("message", msg);
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        Model model) {
//
//        User user = userService.login(username, password);
//
//        if (user != null) {
//            session.setAttribute("user", user);
//            return "redirect:/";
//        } else {
//            model.addAttribute("message", "Invalid credentials");
//            return "login";
//        }
//    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}