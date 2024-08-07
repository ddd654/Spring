package com.simple.basic;

import com.simple.basic.command.BuilderVO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

//08-07
//1) 테스트 코드 어노테이션 추가
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //4) 테스트 코드 사용하기
public class TestCode01 {

    //Alt + enter 로 실행한다
    //2) 테스트 어노테이션
    @Test
    @Order(2) // 5) 실행 순서 지정하기 @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 와 함께 사용됨
    public void testCode01() {
        System.out.println("code 실행됨~~");
    }

    @Test
    @Order(1) //6) 실행순서
    public void testCode02() {
        System.out.println("테스트 코드 2");
    }

    //3) 위에서 아래로 순서대로 실행되는 것이 아닐 수 있다


    //5. 리턴 Builder() 타입을 받는다
    @Test
    public void testCode03(){
       BuilderVO vo = BuilderVO.builder().name("사과").age(22).build();

        System.out.println(vo.toString());
    }
    //한번 값을 정하면, 변수 값을 바꿀 수 없는 불변성이 생긴다
    //값의 타입을 면확하게 확인할 수 있다
    // 그래도 getter, setter를 쓸 수는 있다
    // > VO 로





}
