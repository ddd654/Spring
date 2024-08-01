package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



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



////8. extends 받기
//public class HomeController extends MultiActionController{
//	
//	@Override
//	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) 
//	throws Exception{
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
//        //10. 디스패쳐 서블릿으로 뷰에대한 경로와 data에 대한 내용을 반환한다
//        //11. homeController 타고 화면 띄움 > 서블렛으로
//        
//	}
//
//	
//}
