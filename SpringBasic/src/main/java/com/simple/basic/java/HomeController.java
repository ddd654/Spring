package com.simple.basic.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // 컴포넌트 스캔이 읽어서 빈으로 생성
public class HomeController {
	
	
	//핸들러 어탭터와 연결한다
	//웹 주소창에 /home 으로 끝나야 이쪽으로 간다
	@RequestMapping("/home")
	public String home() {
		return "home"; // WEB-INF/views/home.jsp
	}
	
}
