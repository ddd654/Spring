package com.simple.basic.util.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // AOP클래스
@Component // 이 클래스는 component-scan에 읽혀서 bean으로 생성된다
public class LogAdvice {

	// 2_ 해당클래스에서 로그를 사용함 - base 패키지 밑에 있어야한다
	public static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

	// advice - 공통기능
	// point cut - 내가 적용할 메서드에 advice를 부착하는 범위

	// 맨압 *은 모든 접근제어자, 마지막 *(..)은 모든 메서드에
	// @Before("execution(*com.simple.basic.controller.*Controller.*(..))")
	//@Before("execution(* com.simple.basic.repository.score.*ScoreServiceImpl.*(..))")
	public void beforeLog() {
		// 위에 경로 before 를 지나면 동작되는곳
		System.out.println("-----메서드 실행전");
	}

	//@After("execution(* com.simple.basic.repository.score.*ScoreServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("-----메서드 실행하고 나서");

	}

//	@AfterThrowing( pointcut =
//	"execution(*com.simple.basic.service.score.*ScoreServiceImpl.*(..))",
//	throwing = "e" //에러를 처리할 변수명
//	)
	public void exceptionLog(Exception e) {

		System.out.println("coco advice 에러로그: " + e);

	}

	//
	// 이것들 전부 한번에 사용하는게 AROUND 메서드 < 핵심

	// AROUND
	// 리턴을 오브젝트로 만들고, 매개변수로 실행 시점을 결정한다
	// 아랫줄 주석하면 실행막아짐
	
	@Around("* com.simple.basic.repository.score.*ScoreServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint pj) {

		// 여기 비워두면 서비스 실행 안됨

		//1_ 08-06 매개변수를 확인해보자
		System.out.println("실행클래스:  " + pj.getTarget());
		System.out.println("실행메서드:  " + pj.getSignature().toString());
		System.out.println("매개변수값:  " + Arrays.toString(pj.getArgs()));
		
		
		//5_ 실행시간 알아보기1
		long start = System.currentTimeMillis();
		
		//3_  > 로그를 임플에 붙여서 쓸 수도 있다 ex. 스코어 임플
		log.info("실행클래스22:  " + pj.getTarget());
		
		Object result = null;

		try {

			// before
			result = pj.proceed(); // proceed 메서드가 실행되면, 타겟 메서드가 실행
			// after

			//6_ 실행시간 알아보기2
			long end = System.currentTimeMillis();
			
			log.info("실행시간 알아보기  " + (end -start) * 0.001);
			
			//7_파일형태로 로그 남기기 "파일 내릴 경로"
			
			BufferedWriter bos = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\course\\spring\\Spring\\way\\오늘날짜_Log.txt", true));

			bos.write("실행클래스22:  " + pj.getTarget() + "\n");
			bos.write("실행메서드:  " + pj.getSignature().toString());
			bos.write("매개변수값:  " + Arrays.toString(pj.getArgs()));
			bos.write("실행시간 알아보기  " + (end -start) * 0.001);
			bos.flush();
			
			bos.close();
			
			
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
