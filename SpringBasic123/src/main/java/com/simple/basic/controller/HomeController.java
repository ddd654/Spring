package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//13. 컨트롤러 새로해서 확인하기
@Controller
public class HomeController{
	
	
	
	@RequestMapping("/test/aaa")
	public String home(){
		
		System.out.println("컨트롤러 지나는지 확인하기");
		
		return "/WEB-INF/views/home.jsp";
	}
	
	// > 서블릿으로
}