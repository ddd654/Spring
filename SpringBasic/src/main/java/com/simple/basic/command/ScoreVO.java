package com.simple.basic.command;

public class ScoreVO {

	//sno 추가해서 다시 만듬 > list. jsp 로가서 ${vo.sno} 수정하면 한기능 끝
	private int sno;
	private String name;
	private String kor; //정수로하면 input 공백 이슈 생김
	private String eng;
	private String math;
	
	//생성자
	public ScoreVO() {
		
	}

	//getter setter
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public ScoreVO(int sno, String name, String kor, String eng, String math) {
		super();
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//생성자
//	public ScoreVO() {
//		
//	}
//	
//	//
//	public ScoreVO(String name, String kor, int eng, int math) {
//		super();
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}
//
//	//getter setter
//	public String getName() {
//		return name;
//	}
//
//
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getKor() {
//		return kor;
//	}
//
//
//	public void setKor(String kor) {
//		this.kor = kor;
//	}
//
//
//	public int getEng() {
//		return eng;
//	}
//
//
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//
//
//	public int getMath() {
//		return math;
//	}
//
//
//	public void setMath(int math) {
//		this.math = math;
//	}
	
	
	
}
