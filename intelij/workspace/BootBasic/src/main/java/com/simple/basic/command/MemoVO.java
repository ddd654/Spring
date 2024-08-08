package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoVO {

    private Long mno;

    //@Size(min = 5, message = "최소 5글자 이상")
    @NotBlank(message = "빈곳을 채워주세요~~~~~~~~~~~~")
    private String memo;

    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 000-0000-0000 형식입니다")
    @NotNull(message = "채워주세요")
    private String phone;

    //@Pattern(regexp = "[0-9]{4}")
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String pw;

    //초기값 n
    private String secret = "n";
}
