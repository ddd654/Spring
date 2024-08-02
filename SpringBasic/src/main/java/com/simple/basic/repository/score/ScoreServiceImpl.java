package com.simple.basic.repository.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;

@Service("co") // 반드시 component-scan에 의하여 읽힌다
public class ScoreServiceImpl implements ScoreService {

	// 15. 맨아래 퍼블릭 주석하고 실행해줌
	@Autowired
	@Qualifier("coconut")
	ScoreDAO scoreDAO;

	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

//	public void regist(ScoreVO vo) {
//		
//		//6. 확인하기 > 컨에서 3. 임플객체
//		System.out.println("service layout123");
//		
//	}

	// 20. >컨
	public ArrayList<ScoreVO> getScore(){
			return scoreDAO.getScore();
		}

}
