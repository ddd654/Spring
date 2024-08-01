package ex02_constructor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//자바
//		Hotel hotel = new Hotel(new Chef());
//		hotel.getChef().cooking();
		
		
		//Spring
		//박스, 컨테이너
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		Hotel hotel =ctx.getBean("hotel", Hotel.class); //"파란글"은 context에 있는 아이디 값
		hotel.getChef().cooking();
		
		
	}
}
