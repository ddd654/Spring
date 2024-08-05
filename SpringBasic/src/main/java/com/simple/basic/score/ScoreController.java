package com.simple.basic.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.repository.score.ScoreService;
import com.simple.basic.service.score.impl.ScoreDAO;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	
	
	
	

	// 8. ScoreService 계속 쓸꺼니까 여기다가
	// ScoreService service = new ServiceServiceImpl(); << 이것보다 더 좋은 방법이 임플을 빈으로 만드는것
	// 호출될때마다 객체가 생성되면 스프링에 안좋은듯하여 바꿈 > 임플로
	// > 서블릿 컨텍스트 빈으로 생성 후 > 컨트롤러로

	//10. Impl을 bean으로 등록
	//ScoreService를 찾아서 연결 해줌 >> 확인 후 주석 및 컨텍스트랑 임플로
	@Autowired
	@Qualifier("co") // ~Impl2가 있으면 중복을 피하려고 Qualifier 필요
	ScoreService scoreService; //임을이 이 안으로
	
	
	
	
	// > 즉, 반드시 Autowired 쓰고 Impl에 서비스를 붙여준다
	// 여기까지 한 서비스 세트 > DAO 만들기 수업 > 패키지랑 ScoreDAO ScoreDAOImpl 만듬
	
	// 1. 목록
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//17. select해서 model에 담아서 화면으로 >서비스 DAO
		

		//21. 화면으로 나가야한다 위 괄호에 모델로 해서 
		ArrayList<ScoreVO> list = scoreService.getScore();
		model.addAttribute("list", list);
		//22. 리스트를 파란 리스트에 담아서 화면에 나가자 > scoreList.jsp 에 추가
		
		
		return "/service/scoreList"; // 화면
	}
	

	// 2. 등록
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "/service/scoreRegist";
	}

	// 3. 등록 기능 > 화면 나오는지 확인 > VO 만들러
	@RequestMapping(value = "/scoreForm", method = RequestMethod.POST)
	public String scoreForm(ScoreVO vo) { // vo 값 받기

		// 7. 서비스 레이어로 넘어가게 객체만들고 넘김 > 맨위에 적음
		// ScoreService service = new ServiceServiceImpl();
		scoreService.regist(vo);

		return "/service/scoreResult";// 결과화면

	}
	// 4. 서비스 스코어 패키지 만들기 > service 클래스와 서비스 임플 만듬

	
	
	//2. 삭제요청기능 만들기 > 생각, 번호? 인덱스 번호 > jsp 키
	@RequestMapping("/deleteScore")
	public String deleteScore(@RequestParam("sno") int sno) {
		
		//6) sno 확인 > 인터페이스 스코어 서비스
		System.out.println(sno);
		
		//11) > 스코어 서비스 임플
		scoreService.delete(sno);
		
		// 13) 삭제 메서드 실행 후 다시 목록화면으로 가게 redirect
		return "redirect:/service/scoreList"; 
	}
	
}
