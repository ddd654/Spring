package com.simple.basic.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
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
	// MVC2이고, 모두 forward 방식

	// void 형은 바로 적힌 경로로 띄워준다
	// String 형은 리턴에 적힌 화면경로로 띄워준다
	// return 'redirect/경로~~~'; 가끔 리다이렉트는 이렇게

	// 1. request/req_ex01 jsp 파일 만들어준다 뭐좀 적고> 컨트롤러

//	//4. void형은 들어온경로가 나가는 경로 = 그대로 띄운다
//	@RequestMapping("/req_ex01")
//	public void ex01() {
//		
//	}

	// 3.
	@RequestMapping("/req_ex01")
	public String ex01() {
		return "request/req_ex01"; // 화면경로
	}

	// 5.
	// @RequestMapping( value = "/basic", method = RequestMethod.GET) //옵션 = 값, GET만
	// 허용함
	// @RequestMapping(value = "/basic", method = RequestMethod.POST) // POST만 허용
	// @RequestMapping("/basic") // 겟, 포스트 둘다 허용

	// jsp에서 배이직 2, 3 만들어줌
	@RequestMapping({ "/basic", "/basic2" })
	public String basic() {

		System.out.println("basic요청 실행됨");
		return null;
	}

	// @GetMapping("basic3") // RequestMapping + GET만 허용하기
	@PostMapping("/basic3") // RequestMapping + POST만 허용하기
	public String basic3(/* request 선언하면 사용가능 */) {

		System.out.println("배이직 3 실행됐을때");
		return null;
	}

	//////////////////////////////////////////

	// ex02 화면 요청
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}

//	//7. 들어오는 화면 > 나가는 화면
//	@RequestMapping(value="/param", method=RequestMethod.POST)
//	public String param(HttpServletRequest request) { //8. 리퀘스트 객체로 값 받기
//		
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		System.out.println(request.getParameterValues("inter")); //배열
//		
//		
//		//화면처리 후
//		
//		
//		return "request/req_ex02_ok"; // 로 나간다
//		
//		//9. 한글 처리를 위해 web.xml 파일에 한글 처리 필터 추가함
//	}

	
	//@RequestParam방식 - 반드시 값을 화면에서 넘겨야 됨(필수)
		//required = false 는 값이 없더라도 통과하게 됩니다.
		//defaultValue는 값이 없을때 기본값을 지정할 수 있습니다.
	
//	@RequestMapping(value="/param", method=RequestMethod.POST)
//	public String param(@RequestParam("id") String x, // id 받아서 x에 저장
//						@RequestParam("pw") String y,
//						@RequestParam("inter") String[] arr) { //10. input 태그의 네임값, id를 받아서 x에 맵핑
//						//@RequestParam("inter") ArrayList<String> list
//		//화면처리 후
//
//		
//		//11. 확인
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(arr);
//		
//		
//		return "request/req_ex02_ok"; // 로 나간다
//		
//	}

	
	
	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(MemberVO vo) {// jsp에서 name이 setter 로 넘어간다
		
		System.out.println(vo.toString());
		
		// 잘~~~~ 처리해서~~
		// 결과화면
		return "request/req_ex02_ok";
	}
	
	//12. VO 만들어서 줌

}
