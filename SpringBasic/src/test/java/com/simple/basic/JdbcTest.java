package com.simple.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class) // Junit을 스프링 테스트 코드로 실행한다
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") // 내가 동작할 스프링 경로파일, 서버를 안키고 실행하니 필요
public class JdbcTest {

	// 2. DB 연결하기
	@Autowired
	// DataSource ds; //root-context.xml 에 선언된 db정보를 담은 객체

	// @Test //1. test 코드로 동작
	public void testCode01() {
		System.out.println("텟 hello");

		// main 처럼 동작한다 대신 일부분만 실행

		// 3. 다 적고 > 스코어 DAO impl

		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT sysdate as Time FROM dual");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String Time = rs.getString("Time");
				System.out.println(Time);
			}

			conn.close();
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	@Autowired
	DataSource ds; // context.xml에 있던 ds

	// @Autowired
	// SqlSessionFactory sqlSessionFactory;
	// mapper를 사용할것이니 필요없다


	@Autowired
	TestMapper testMapper;
	
	// 세션팩토리 추가 후
	@Test
	public void testCode02() {

		//System.out.println("코드 테스트 하기2");
		String time = testMapper.getTime();
		System.out.println("코드 테스트 2" + time);
		
		
	}
	
	
	

	
	
}
