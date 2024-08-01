package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {

		// 자바
//		SpringTest test = new SpringTest();
//		test.hello();

		// Spring 방식으로 실행하기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");

		SpringTest test = ctx.getBean(SpringTest.class);
		test.hello();

		// IoC 컨테이너안에 만들어진 bean을 test에 받아서 사용한다

		SpringTest test2 = ctx.getBean(SpringTest.class);
		System.out.println(test == test2);
		//프로토 타입이면 false
		
		
		
	}
}
