package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVo authuser = userservice.exeLogin(userVo);
		System.out.println(authuser);
		
		session.setAttribute("authUser", authuser);
		return "redirect:/main";
	}
	
	

}
