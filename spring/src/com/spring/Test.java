package com.spring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class Test {
	
	@RequestMapping("toregisterpage")
	public String toregisterpage() {
		return "register";
	}
	
	@RequestMapping("register")
	public String register(@Valid User user,BindingResult result){
		System.out.println("password====="+result.getFieldValue("username")+"=");
		System.out.println("password====="+result.getFieldValue("password")+"=");
		if(result.hasErrors()) {
			return "register";
		}
		return "hello";
	}
	
}
