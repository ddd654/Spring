package com.simple.basic;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.memo.MemoMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//08-08 마이바티스 부분
//1) 테스트 코드 어노테이션 추가
@SpringBootTest
public class TestCode02 {

    @Autowired
    MemoMapper memoMapper;

    @Test
    public void testCode01(){
        String result = memoMapper.hello();
        System.out.println("현재시간~~~~~~~~" + result);

    }



}
