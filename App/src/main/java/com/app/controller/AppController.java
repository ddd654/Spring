package com.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service123") 
public class AppController {
	
	@RequestMapping("/first")
	public String base() {
		
		System.out.println("실행123");
		
		return "/service123/first";
	}
	
	
}
