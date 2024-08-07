package com.simple.basic.command;

import lombok.Builder;
import lombok.ToString;

//8.builder()를 바로 사용가능
@Builder
@ToString
public class BuilderVO {

    //1. 멤버변수
    private String name;
    private int age;


    /*

    //3. 외부 클래스 생성자는 내부클래스 생성자를 매개변수로 받는다
    private BuilderVO(Builder builder123) { //private이니 다른곳에서 참조 못하겠지
        this.name = builder123.name;
        this.age = builder123.age;
    }

    //4. 외부에서 객체 생성을 요구하면, 내부클래스를 생성해서 반환한다
    public static Builder builder333() {
        return new Builder();
    }
    // > TestCode에서 텟 > 실행시 > Builder() 타입을 받는다

    
    //8. 값 확인용 toString 오버라이딩
    // toString 적고 아래꺼 엔터
    @Override
    public String toString() {
        return "BuilderVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //2. 내부클래스 - 대부분 static으로 만듬
    public static class Builder {

        private String name;
        private int age;

        // 내부 클래스 생성자 제한
        private Builder() {

        }

        //6. setter메서드 (멤버변수값을 받아서, 나 자신을 반환한다)
        public Builder name(String name) {
            this.name = name;
            return this; // 나 자신
        }

        public Builder age(int age) {
            this.age = age;
            return this; // 나 자신 리턴
        }

        //7. build 실행하면, 외부클래스 BuilderVO를 생성해서 리턴
        public BuilderVO build(){
            return new BuilderVO(this);
        }
        // > 확인하러 test코드로

    }

    */

}
