package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

//13. 서비스임플처럼 어노테이션 추가
@Repository("coconut") // 14. component scan애 일으켜야 > setviceimpl
public class ScoreDAOImpl implements ScoreDAO {

	//16. 리스트안에 데이터있다고 DB로 가정 > jsp 목록에 나와야 하니 컨 목록으로
	ArrayList<ScoreVO> list = new ArrayList<>();
		
	// 12. 추가하고
	@Override
	public void regist(ScoreVO vo) {

		System.out.println("repository layer" + vo);
		list.add(vo);
	}

	//19. 여기 추가됨, 서비스 임플에도 추가해준다
	@Override
	public ArrayList<ScoreVO> getScore() {

		return list;
	}

}
