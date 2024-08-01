package ex04_quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("autowired-context.xml");
		
		
		Computer cp = ctx.getBean("computer", Computer.class);
		cp.computerInfo();
	}

}
