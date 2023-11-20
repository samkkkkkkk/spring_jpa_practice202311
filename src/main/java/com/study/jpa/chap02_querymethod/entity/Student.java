package com.study.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Setter // 실무적 측면에서 setter는 신중하게 선택할 것.
@Getter
@ToString @EqualsAndHashCode(of = "id") // id만 검사해서 두 객체가 같은지 비교해 준다. 여려 개를 지정하고 싶을 때는 {}를 이용
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @Column(name = "stu_id")
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid", name = "uid")
    private String id; //uuid를 이용해서 고유한 랜덤 문자열을 이용해서 PK지정

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;

    private String major;



}
