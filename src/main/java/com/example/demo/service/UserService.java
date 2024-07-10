package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.LoginDAO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository ur;
public String Register(User user) {
	User us=ur.UserExistence(user.getEmail(), user.getUsername());
	if(us!=null) {
		return "Email/Username already Exists";
	}
	else {
		ur.save(user);
		return "Registered Successfully";
	}
}
public User login(LoginDAO da) {
	User us=ur.LoginCheck(da.getUsername(), da.getPassword());
	if(us!=null) {
		return us;
	}
	else {
		return null;
	}
}
}
