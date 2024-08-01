package ex03.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {

	// 생성자, 메서드에, 멤버변수도 사용할 수 있다
	// 멤버 변수에 사용해보기
	@Autowired //(required = false)
	// required = false 는 스프링이 주입할 빈이 없으면 
	// 무시하고 지나가라는 속성이다

	@Qualifier("doc1") //qualifier는 동일 객체가 있을때, 이름으로 강제 주입을 넣어주는 어노테이션
	private Document document;
	// 기본생성자가 없어서 나중에 에러가 나올 수 있다

	public Printer() { // 기본 생성자

	}

	// 빈객체를 자동으로 주입한다
	// 1. 타입으로 찾아서 주입 예) Document 타입
	// 2. 없으면 이름으로 찾아서 주입

	// atowired-context.xml 에서 활성화태그 쓰고 적으면 적용됨
	// @Autowired
	// 생성자 주입
	public Printer(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	// getter, setter로 만든다
	// 세터주입
	public void setDocument(Document document) {
		this.document = document;
	}

}
