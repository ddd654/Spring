package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

//13. 서비스임플처럼 어노테이션 추가
@Repository("coconut") // 14. component scan애 일으켜야 > setviceimpl
public class ScoreDAOImpl implements ScoreDAO {

	// 16. 리스트안에 데이터있다고 DB로 가정 > jsp 목록에 나와야 하니 컨 목록으로
	ArrayList<ScoreVO> list = new ArrayList<>();

	// 12. 추가하고
	@Override
	public void regist(ScoreVO vo) {

		System.out.println("repository layer" + vo);
		list.add(vo);
	}

	// 19. 여기 추가됨, 서비스 임플에도 추가해준다
	@Override
	public ArrayList<ScoreVO> getScore() {

		return list;
	}

	// 10)//index 번호로 삭제 > 컨으로 연결
	@Override
	public void delete(int sno) {
		// TODO Auto-generated method stub

		list.remove(sno); 
	}
	
	
	
//	//4. 이제 필요한 기능들 만들기 등록, 수정, 삭제, 등등
//	@Autowired
//	DataSource ds;
//	
//	@Autowired
//	public void regist(ScoreVO vo) {
//		//list.add(vo);
//		//insert 작업
//	}

}
