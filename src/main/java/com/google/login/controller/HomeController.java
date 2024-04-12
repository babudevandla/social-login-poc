package com.google.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String login() {
		System.out.println("index page !..");
		return "index";
	}
	
	@RequestMapping(value = "/sociallogin",method = RequestMethod.GET)
	public String sociallogin() {
		System.out.println("sociallogin page !..");
		return "sociallogin";
	}
}
