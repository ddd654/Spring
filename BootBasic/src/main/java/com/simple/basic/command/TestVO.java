package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //모든 멤버변수를 받는 생성자
@NoArgsConstructor //기본생성자
@Data // << 이거 쓰면, getter, setter생성, toString오버라이딩 자동
//@Setter
//@Getter
//@ToString
@Builder
public class TestVO {
    private int num;
    private String name;
    private int age;
    private String addr;
}
