package ex05.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.SpringTest;
import ex02_constructor.Chef;
import ex02_constructor.Hotel;
import ex02_setter.MemberDAO;
import ex02_setter.MyDataSource;

@Configuration // 자바설정파일
public class Javaconfig {
	
	//<bean id="test" class="ex01.SpringTest" scope="prototype"></bean>
	//위 빈과 똑같은 문장, 생성자 주입 모형들
	@Bean
	public SpringTest test() {
		return new SpringTest();
	}
	
//	<bean id="chef" class="ex02_constructor.Chef"></bean>
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	
//	<bean id="hotel" class="ex02_constructor.Hotel"> 
	@Bean Hotel hotel() {
		return new Hotel( chef() );
	}
	
	
//	<bean id="ds" class="ex02_setter.MyDataSource">
//	<!-- <property name="set이름" value="값"></property> -->
//
//	<property name="url" value="jdbc:oracle:thin:@Localhost~~"></property>
//	<property name="uid" value="jsp"></property>
//	<property name="upw" value="jsp"></property>
//	
//	</bean>
	
	//Bean, 위와 같음
	@Bean
	public MyDataSource ds() {
		MyDataSource ds = new MyDataSource();
		ds.setUid(null);
		ds.setUpw(null);
		ds.setUrl(null);
		return ds;
		
	}
	
//	<bean id="memberDAO" class="ex02_setter.MemberDAO">
//	<!-- 객체타입이 들어갈때는 ref안에 써넣는다 -->
//	<property name="myDataSource" ref="ds"></property>
//	</bean>
	
	//위와 같음
	@Bean
	public MemberDAO dao() {
		MemberDAO dao = new MemberDAO();
		dao.setMyDataSource(ds());
		return dao;
	}
	
	//자바코드로 쓰게되면 이렇게, xml파일로 쓸꺼면 다르게
}
