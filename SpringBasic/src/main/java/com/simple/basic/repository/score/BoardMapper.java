package com.simple.basic.repository.score;

import java.util.ArrayList;

import com.simple.basic.command.BoardVO;

public interface BoardMapper {
	
	//interface로 만들것
	
	//등록기능 메서드
		public void regist(BoardVO vo);
		
		//목록기능 가져오기
		public ArrayList<BoardVO> getBoard();


		//삭제기능
		public void delete(int sno2);
}
