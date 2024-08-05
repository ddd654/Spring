package com.simple.basic.repository.score;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardVO;

@Service("mo")
public class BoardServiceImpl implements BoardService{

	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void regist(BoardVO vo) {
		// TODO Auto-generated method stub
		boardMapper.regist(vo);
	}

	@Override
	public ArrayList<BoardVO> getBoard() {
		// TODO Auto-generated method stub
		return boardMapper.getBoard();
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		boardMapper.delete(num);
	}

}
