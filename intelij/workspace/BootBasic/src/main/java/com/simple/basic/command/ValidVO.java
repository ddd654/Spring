package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidVO {

    /*
    @NotNull   null 제외 가능
    @NotEmpty   null 제외, 공백 제외
    @NotBlank   null - 공백 재외, 화이트 스페이스
    @Pattern
    @Email
    @Max
    @Min
    @Size
    ...
    * */



    @NotBlank(message = "이름 필수!")
    private String name;
    
    @NotNull(message = "급여를 적어주세요!!") //안적으면 에러나는거
    private Integer salary; // 유효성 검사하는 필드는 wrapper 클래스로 작성
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 000-0000-0000 형식입니다")
    private String phone;
    @NotBlank
    @Email(message = "이메일 형식으로 적어주세요~") // 공백은 통과해야
    private String email;

    // >> 화면처리로


    //quiz용
    @NotNull(message = "비어 있어요")
    private String id;
    
    @NotNull(message = "채워주세요")
    private String pw;
}
