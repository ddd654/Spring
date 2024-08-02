package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import com.simple.basic.command.ScoreVO;

public interface ScoreDAO {

	//11. regist
	public void regist(ScoreVO vo); //등록
	
	//18. 조회기능 만들기 > 임플로
	public ArrayList<ScoreVO> getScore();
	
}
