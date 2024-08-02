package com.simple.basic.score;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	//1. 목록
	@RequestMapping("/scoreList")
	public String scoreList() {
		return "service/scoreList"; //화면
	}
	
	//2. 등록
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	//3. 등록 기능 > 화면 나오는지 확인 > Vo 만들러
	@RequestMapping(value = "/scoreForm", method = RequestMethod.POST )
	public String scoreForm() {
		
		return "service/scoreResult";// 결과화면
		
	}
	
	
	
}
