package com.simple.basic.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper // 매퍼라는 뜻
public interface TestMapper {
	//sqlmap 폴더에다가 인터페이스 이름과 똑같이 xml 파일 만들기
	//기능 넣어야해서
	
	public String getTime();

}
