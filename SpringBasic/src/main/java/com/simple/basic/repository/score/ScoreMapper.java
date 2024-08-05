package com.simple.basic.repository.score;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.ScoreVO;

@Mapper
public interface ScoreMapper {
	//sqlmap 안에 ScoreMapper.xml 만들어서
	
	
		// 서비스에서 그대로 갖고오기
		// 5. 등록기능 만들기 > 괄호안에 VO 관통 > 임플에서 메서드 오버라이딩 해야함
			public void regist(ScoreVO vo);
			// public 안적어도 괜찮으나 적음

			// 18.
			public ArrayList<ScoreVO> getScore();

			// 7) 삭제 메서드 추가 > 자식 오버라이드
			public void delete(int sno); 
		
}
