package com.maktony.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Dao 역할을 해줌 DB Layer 접근자임    인터페이스 생성후 JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
//@Repository를 추가할 필요도 없음, Entitiy클래스와 기본 Entity Repository는 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
