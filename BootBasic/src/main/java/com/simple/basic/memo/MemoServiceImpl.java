package com.simple.basic.memo;

import com.simple.basic.command.MemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//컨 세팅 > 파일 만들고서
//1. 서비스 어노테이션 > 컨
@Service("memoService")
public class MemoServiceImpl implements MemoService {

    //3. 매퍼 구현체를 넣어준다
    @Autowired
    MemoMapper memoMapper;

    @Override
    public void regist(MemoVO vo) {
        memoMapper.regist(vo);

    }

    @Override
    public ArrayList<MemoVO> getList() {
        return memoMapper.getList();
    }

}
