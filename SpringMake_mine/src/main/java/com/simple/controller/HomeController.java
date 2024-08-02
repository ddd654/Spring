package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//13. 컨트롤러 새로해서 확인하기
@Controller
public class HomeController{
	
	@RequestMapping("/test/aaa") //요청경로
	public String home(){
		
		System.out.println("컨트롤러 지나는지 확인하기");
		
		//16. 주석하고 home으로 리턴 수정 
		//return "/WEB-INF/views/home.jsp"; //화면으로 보일 경로
		return "home";
		
		//17. resources폴더 만들고 css 만듬
		// css나 jsp는 컨트롤러를 거치지 않게 해야한다 > 서블릿
	}
	
	// > 13. > 서블릿으로
}









//
//
//
//
////8. extends 받기
//public class HomeController extends MultiActionController{
//	
//	@Override
//	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) 
//	throw Exception{
//        // 처리 로직
//
//		System.out.println("컨트롤러까지 연결됨");
//		
//		//요청 분기
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("data", "hello");
////		mv.setViewName("뷰의 경로");
//		mv.setViewName("/WEB-INF/views/home.jsp");
//        
//        return mv; 
//        
//        //9.views 폴더 > jsp 하나 만들어준다>
//        //10. 디스패쳐 서블릿으로 뷰에대한 경로와 data에 대한 내용을 반환해준다
//        //11. homeController 타고 화면 띄움 > 서블렛으로
//        
//	}
//
//	
//}
