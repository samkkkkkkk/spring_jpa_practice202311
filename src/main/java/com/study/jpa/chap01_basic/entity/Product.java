package com.study.jpa.chap01_basic.entity;

import jdk.jfr.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id") // 필드명은 id 컬럼명은 prod_id
    private long id;
    @Column(name = "prod_name", nullable = false, length = 30)
    private String name;

    private  int price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp  // dafalut sysdate
    @Column(updatable = false) // 등록시간이 한번 결정되면 수정이 안되도록 막아줌
    private LocalDateTime createDate;
    
    @UpdateTimestamp //업데이트될 때 자동으로 세팅
    private LocalDateTime updateDate;

    public enum Category {

        FOOD, FASHION, ELECTRONIC
    }


}
