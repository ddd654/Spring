package com.simple.basic.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemberVO;


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
	
//	//3. void형은 들어온경로가 나가는 경로 = 그대로 띄운다
//	@RequestMapping("/req_ex01")
//	public void ex01() {
//		
//	}
	
	//2. 웹 주소창에 http://localhost:8181/basic 여기에 이어서 /request/req_ex01/
	@RequestMapping("/req_ex01")
	public String ex01() {
		return "request/req_ex01"; //보여줄 화면의 경로
	}
	
	//4. GET 방식과 POST 방식만 허용하는법, 키 = 값 
	//@RequestMapping(value = "/basic", method = RequestMethod.GET) //get만 허용함
	//@RequestMapping(value = "/basic", method = RequestMethod.POST) //post만 허용함
	//@RequestMapping("/basic") //get, post 둘다 허용함
	@RequestMapping({"/basic", "/basic2"}) //다른 경로도 허용한다
	public String basic() {
		
		System.out.println("basic요청 실행됨");
		return null; 
	}
	 
	//4. 좀더 짧게 쓰기
	//@GetMapping("/basic3") //리퀘스트맵핑 + get만허용
	@PostMapping("/basic3") //리쉐스트맵핑 + post만허용
	public String basic3() {
			
		System.out.println("basic3요청 실행됨");
		return null;
	}
	
	///////////////////////////////////////////////////////
	
	//5. jsp도 같이 만들고서
	//ex02화면요청
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}
	
	
	//리퀘스트 객체로 값 받기
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param(HttpServletRequest request) {
//		
//		System.out.println( request.getParameter("id") );
//		System.out.println( request.getParameter("pw") );
//		System.out.println( request.getParameterValues("inter") );
//		//잘~~~~ 처리해서~~
//		//결과화면
//		return "request/req_ex02_ok";
//	}
	
	
	//@RequestParam방식 - 반드시 값을 화면에서 넘겨야 됨(필수)
	//required = false 는 값이 없더라도 통과하게 됩니다.
	//defaultValue는 값이 없을때 기본값을 지정할 수 있습니다.
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param( @RequestParam("id") String x, //id를 받아서 x맵핑
//						 @RequestParam("pw") String y,
//						 @RequestParam(value = "inter", required = false, defaultValue = "" ) ArrayList<String> list ) { 
//		
//		
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(list);
//		//잘~~~~ 처리해서~~
//		//결과화면
//		return "request/req_ex02_ok";
//	}

	
	//6. VO=DTO, 패키지 만들어서 VO 만들고, 생성자, 게터 만듬
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param( MemberVO vo  ) { 

		System.out.println(vo.toString());
				
		//잘~~~~ 처리해서~~
		//결과화면
		return "request/req_ex02_ok";
	}
	
	
	
	
	
	
	
}





