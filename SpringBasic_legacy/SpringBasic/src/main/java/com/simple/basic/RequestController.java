package com.simple.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//2. 컨트롤러 붙이기

@Controller
//3. 요청 경로를 여기에 적어도 작동된다, 이 컨트롤러 모든 요청
@RequestMapping("/request")
public class RequestController {
	//MVC2이고, 모두 forward 방식
	
	//void 형은 바로 적힌 경로로 띄워준다
	//String 형은 리턴에 적힌 화면경로로 띄워준다
	//return 'redirect/경로~~~'; 가끔 리다이렉트는 이렇게
	
	//1. request/req_ex01 jsp 파일 만들어준다 뭐좀 적고> 컨트롤러
	
//	//4. void형은 들어온경로가 나가는 경로 = 그대로 띄운다
//	@RequestMapping("/req_ex01")
//	public void ex01() {
//		
//	}
	
	//3. 
	@RequestMapping("/req_ex01")
	public String ex01() {
		return "request/req_ex01"; //화면경로
	}
	
	//5.
	//@RequestMapping( value = "/basic", method = RequestMethod.GET) //옵션 = 값, GET만 허용함
	@RequestMapping(value = "/basic", method = RequestMethod.POST) // POST만 허용
	public String basic() {
		
		System.out.println("basic요청 실행됨");
		return null;
	}
	
	
}
