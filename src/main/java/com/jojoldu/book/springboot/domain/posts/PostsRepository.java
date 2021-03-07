package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Post 클래스로 DB를 접근하게 해줄 JpaRepository(인터페이스로 생성)
public interface PostsRepository extends JpaRepository<Posts, Long> {
    //JpaRepository<Entity클래스, PK타입>상속하면 CRUD메소드가 자동 생성

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
