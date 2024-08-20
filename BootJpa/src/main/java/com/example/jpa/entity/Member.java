package com.example.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
