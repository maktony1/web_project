package com.maktony.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter                //lombok 어노테이션
@NoArgsConstructor     //lombok 어노테이션
@Entity                //@Entity JPA 어노테이션 ( 테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함 ex) SalesManager.java -> sales_manager table
public class Posts {

    @Id     //해당 테이블의 PK 필드를 나타냄
    //@GeneratedValue (PK의 생성규칙을나타냄, 스프링부터 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가됨), 2.0 버전 1.5 버전 차이 있음
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column 테이블의 칼럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이됨, 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    // 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex:title), 타입을 TEXT로 변경하고 싶거나 (ex:content)등의 경우에 사용합니다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
