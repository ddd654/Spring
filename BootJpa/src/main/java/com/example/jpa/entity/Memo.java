package com.example.jpa.entity;

import lombok.*;

import javax.persistence.*;

//08-20
@Entity // jpa가 entity로 관리한다
@Table(name = "MEMO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {

    //@Id // pk로 사용하기 mno
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "연결 이름")
    //@SequenceGenerator(name = "연결 이름", sequenceName = "시퀀ㅅ이름", initialValue = 1 /*초기값 1*/, allocationSize = 1/*1씩 증가*/)
    //위 두 문장은 오라클에서 pk 사용하는 법이다

    //엔티티를 정릐하면 hibernate가 DDL을 대신 해준다, > properties에서 update 옵션이 해주는 것임

    // mySQL
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long mno;

    @Column(length = 200, nullable = false)
    private String writer;/member_id 칼럼에 주키 저장하기
    private Member member;


}

//이렇게  mySQL에 memo TABLE을 만들어 준다

@Column(columnDefinition = "varchar(200) default 'y'") //제약을 넣는 경우
private String text;


//N :1
//FK d칼럼명을 명시하지 않으면 Memmber 엔티티에 주키로 생성
@ManyToOne
@JoinColumn(name = "member_id") /