package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberVO {

    @NotNull(message = "빈곳이 있어요")
    @Pattern(regexp = "[a-zA-Z0-9]{8,}",
            message = "8자 이상")
    private String id;


    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호 영문자,숫자,특수문자 조합 8글자 이상입니다")
    @NotNull(message = "빈곳이 있어요2")
    public String pw;
}
