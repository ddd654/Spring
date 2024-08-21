package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberMemoDTO {

    //멤버, 메모 엔티티의 필요한 값들을 명시하자
    private String id; //Member
    private String name; //Member
    private LocalDateTime signDate; //Member
    private long mno; //memo 꺼
    private String writer; //memo
    private String text; //memo

}
