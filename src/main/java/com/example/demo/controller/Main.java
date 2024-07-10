package com.example.demo.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DAO.LoginDAO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class Main {
	@Autowired
	UserService us;
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home");
        return mav;

    }
    @PostMapping("/register")
    public ModelAndView index1(@ModelAttribute User user, Model model) {
    	String msg=us.Register(user);
    	if(msg.equals("Registered Successfully")) {
    		return new ModelAndView("login");
    	}
    	ModelAndView mav=new ModelAndView("home");
    			mav.addObject("message", msg);
    	return mav;
    }
    @PostMapping("/login")
    public ModelAndView login(HttpSession session,@ModelAttribute LoginDAO user, Model model) {
    	User det=us.login(user);
    	if(det!=null){
    		model.addAttribute("username", det.getUsername());
    		model.addAttribute("role", det.getRole());
    		model.addAttribute("user_id",det.getId());
    		System.out.println(det.getRole());
    		System.out.println(det.getUsername());
    		return new ModelAndView("main");
    	}
    	ModelAndView mav=new ModelAndView("login");
		mav.addObject("message", "Invalid Credentials");
		return mav;
    	
    }
    }
