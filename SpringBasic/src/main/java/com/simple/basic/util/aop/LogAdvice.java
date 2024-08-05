package com.simple.basic.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // AOP클래스
@Component // 이 클래스는 component-scan에 읽혀서 bean으로 생성된다
public class LogAdvice {

	// advice - 공통기능
	// point cut - 내가 적용할 메서드에 advice를 부착하는 범위

	// 맨압 *은 모든 접근제어자, 마지막 *(..)은 모든 메서드에
	// @Before("execution(*com.simple.basic.controller.*Controller.*(..))")
	// @Before("execution(*com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void beforeLog() {
		// 위에 경로 before 를 지나면 동작되는곳
		System.out.println("-----메서드 실행전");
	}

	// @After("execution(*com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("-----메서드 실행하고 나서");

	}

	// @AfterThrowing( pointcut =
	// "execution(*com.simple.basic.service.score.*ScoreServiceImpl.*(..))",
	// throwing = "e" //에러를 처리할 변수명
	// )
	public void exceptionLog(Exception e) {

		System.out.println("coco advice 에러로그: " + e);

	}

	//
	// 이것들 전부 한번에 사용하는게 AROUND 메서드

	// AROUND
	// 리턴을 오브젝트로 만들고, 매개변수로 실행 시점을 결정한다
	
	
	//아랫줄 주석하면 실행막아짐
	
	
	@Around("execution(*com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint pj) {

		// 여기 비어두면 서비스 실행 안됨

		Object result = null;

		try {

			result = pj.proceed(); // proceed 메서드가 실행되면, 타겟 메서드가 실행

		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace(); // 해당 메서드의 에러찍기
		}

		return result; // 메서드의 정상 흐름으로 돌아간다

		// 무얼 확인할 수 있는가?
		// 메서드로 넘어오는 매개변수 확인가능
		// 메서드 실행되는 타겟확인가능
		// 이러한 결과들을 수집해 FileOutput으로 로그를 만들어낼 수 있다

	}

}
