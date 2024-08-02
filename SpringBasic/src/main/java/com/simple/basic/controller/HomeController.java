package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//13. 컨트롤러 새로해서 확인하기
@Controller // 컴포넌트 스캔이 읽어서 빈(객체)으로 생성
public class HomeController {

	// 핸들러 어댑터와 연결
	@RequestMapping("/home")
	public String home() {

		System.out.println("컨트롤러 지나는지 확인하기");

		// return "/WEB-INF/views/home.jsp"; 으로도 썼었음

		return "home"; // WEF-INF/views/home.jsp
	}

	// > 서블릿으로

}
