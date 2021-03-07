package com.jojoldu.book.springboot.domain.posts;


import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor //기본생성자 자동 추가
@Entity // 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity { //BaseTimeEntity를 상속받도록 설정. 저장 및 변경시간 자동생성

    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성규칙
    // GenerationType.IDENTITY 옵션 : auto increment를 위해 필요
    private Long id;

    @Column(length = 500, nullable = false) //칼럼은 VARCHAR(255)가 디폴트
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        //업데이트 쿼리가 없음
        //JPA의 영속성 컨텍스트 때문에 가능. (영속성 컨텍스트 : 엔티티를 영구저장하는 환경)
        //JPA의 핵심 : 엔티티가 영속성 컨텍스트에 포함되어있냐 아니냐로 갈림
        //더티체킹?????
        this.title = title;
        this.content = content;
    }
}