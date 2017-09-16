package com.spring;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class welcome {
	@RequestMapping("/error")
	public String index(HttpSession session) {
		System.out.println(session.getAttribute("user"));
		return "error";
	}
}
