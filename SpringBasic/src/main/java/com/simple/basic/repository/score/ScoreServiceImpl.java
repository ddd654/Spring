package com.simple.basic.repository.score;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.util.aop.LogAdvice;

@Service("co") // 반드시 component-scan에 의하여 읽힌다
public class ScoreServiceImpl implements ScoreService {

	
	//public static final Logger log = LoggerFactory.getLogger(ScoreServiceImpl.class);

	
//	//SQL 세션 팩토리 및 마이바티스 후 필요 없어서 > 이제부터 ScoreMapper 만들고 기능 추가
//	// 15. 맨아래 퍼블릭 주석하고 실행해줌
//	@Autowired
//	@Qualifier("coconut")
//	ScoreDAO scoreDAO; //자동으로 빈 생성

	
	
	
	//mapper.xml에서 쓴것 이용 완성 후 > VO
	@Autowired
	private ScoreMapper scoreMapper; // 밖에서 못쓰게 private
	
	
	public void regist(ScoreVO vo) {
		//scoreDAO.regist(vo);
		scoreMapper.regist(vo);
		
		System.out.println("AOP클래스 보기용 regist메서드 동작");
	}

//	public void regist(ScoreVO vo) {
//		
//		//6. 확인하기 > 컨에서 3. 임플객체
//		System.out.println("service layout123");
//		
//	}

	// 20. >컨
	public ArrayList<ScoreVO> getScore(){
		//return scoreDAO.getScore();
		System.out.println("AOP클래스 보기용 getScore메서드 동작");

//		//에러용 코드
//		String str=null;
//		str.charAt(0);
		
		return scoreMapper.getScore();
		

		
		}

	//before 메서드 실행부분
	
	// 8) DAO 와 DAO임플도 똑같이
	@Override
	public void delete(int sno) {
		// TODO Auto-generated method stub
		System.out.println("AOP클래스 보기용 delete메서드 동작");

		//12) > 과정은 DAO impl을 거치고 > 컨
		//scoreDAO.delete(sno);
		scoreMapper.delete(sno);
	}
	
	//after 메서드 실행 부분

}
