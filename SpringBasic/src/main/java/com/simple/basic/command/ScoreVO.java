package com.simple.basic.command;

public class ScoreVO {

	private String name;
	private String kor; //정수로하면 input 공백 이슈 생김
	private int eng;
	private int math;
	
	
	//생성자
	public ScoreVO() {
		
	}
	
	//
	public ScoreVO(String name, String kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	//getter setter
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


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}
	
	
	
}
