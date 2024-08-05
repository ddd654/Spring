package com.simple.basic.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.BoardVO;
import com.simple.basic.repository.score.BoardService;

@Controller
@RequestMapping("/board") // board 폴더안에
public class BoardServiceController {
	
	//impl 만들고와서 서비스 추가
	@Autowired
	@Qualifier("mo") //mo 임플이 여기로 들어간다
	BoardService boardService;
	
	//목록화면 띄우기
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		System.out.println("목록화면 실행되나 보기");
		
		ArrayList<BoardVO> list = boardService.getBoard();
		model.addAttribute("list", list);
		return "/board/boardList";
				
	}
	
	//등록화면 띄우기
	@RequestMapping("/boardRegister") //boardRegister
	public String boardRegister() {
		
		System.out.println("등록화면~~");

		
		return "/board/boardRegister";
	}
	//등록기능 만들기 > VO 
	@RequestMapping(value = "/boardForm", method = RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.regist(vo);
		
		System.out.println("등록기능 실행");

		
		return "/board/boardResult"; //Form 오면 레지화면으로
	}
	
	//삭제기능 만들기
	@RequestMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("num") int num) {
		System.out.println(num + " 확인하기");
		
		//삭제 메서드 실행하기
		boardService.delete(num);
		System.out.println("삭제 실행되나 보기");

		return "redirect:/board/boardList";
	
	}
	
	
}
