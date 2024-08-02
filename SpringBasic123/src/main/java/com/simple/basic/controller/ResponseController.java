package com.simple.basic.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//1. jsp 만들고 컨트롤러
@Controller
@RequestMapping("/response")
public class ResponseController {
	
	//화면 요청
	@RequestMapping("/res_ex01")
	public String ex01() {
		
		return "response/res_ex01"; //여기로 다시 내보낸다
	}
	
	//a링크 타고 다음화면 가기
	// 01 > 컨트롤러 > 02
	
	//2. 요청
	@RequestMapping("/res_ex02")
	public String ex02(Model model) {
		//3. model 적고 >  jsp ${키} 적기
		model.addAttribute("data", "사과"); //request.setAttribute(키, 값)과 같음
		model.addAttribute("now", new Date());
		
		
		
		return "response/res_ex02"; //로 간다
	}

}
