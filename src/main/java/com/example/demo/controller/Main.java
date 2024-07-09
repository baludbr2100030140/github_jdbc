package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/")
public class Main {
    @GetMapping("/as")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Welcome to Spring Boot with ModelAndView!");
        return mav;

    }
    @PostMapping("/index")
    public ModelAndView index1(@ModelAttribute User user, Model model) {
    	ModelAndView mav = new ModelAndView("index");
        mav.addObject("email", user.getEmail());
        return mav;
    }
}
