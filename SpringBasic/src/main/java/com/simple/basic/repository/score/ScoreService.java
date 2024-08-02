package com.simple.basic.repository.score;

import java.util.ArrayList;

import com.simple.basic.command.ScoreVO;

public interface ScoreService {
	
	//5. 등록기능 만들기 > 괄호안에 VO 관통 > 임플에서 메서드 오버라이딩 해야함
	public void regist(ScoreVO vo);
	//public 안적어도 괜찮으나 적음

	//18.
	public ArrayList<ScoreVO> getScore();

	
	
	
	
}
