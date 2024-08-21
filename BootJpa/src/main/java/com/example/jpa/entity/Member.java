package com.example.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)//JPA엔티티를 관리는 영속성영역에서 변화를 감지해서 자동으로 변수에 적용해주는 역할
//BootMywebApplication클래스에 @EnableJpaAuditing 를 추가해야합니다.
public class Member {

    @Id //PK
    private String id;
    @Column
    private String name;

    @CreatedDate //JPA를 통해서
    @Column(updatable = false) // 이 컬럼은 JPA로 자동으로 바뀌는 것을 금지
    private LocalDateTime signDate;

    //원투매니 단방향 조인 - 그냥 사용하게 되면, 연관관계의 주인 1이 되면서 맵핑 테이블 자동 생성
    //연관관계 주인 - FK를 관리하는 주체
//    @OneToMany(fetch = FetchType.EAGER) //OneToMany default조인 방식은 Lazy 입니다
//    @JoinColumn(name = "member_id") //N테이블의 member_id컬럼을 FK로 조인 하겠다. (적지 않으면 맵핑테이블 자동생성)
//    private List<Memo> list = new ArrayList<>();


    //양방향 맵핑
    // toString 한쪽 지우기
    @OneToMany(mappedBy = "member")// 1에서 지정하는 거, 연관관계 주인을 나타낸다 = N쪽의 필드명인  member
    private final List<Memo> list = new ArrayList<>();













}
