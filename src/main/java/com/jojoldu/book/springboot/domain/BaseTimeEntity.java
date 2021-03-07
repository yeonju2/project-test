package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함시킨다.
// 모든 Entity의 상위 클래스가 되어, Entity들의 날짜생성을 자동으로 관리
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 변경할때 시간 자동저장
    private LocalDateTime modifiedDate;

}
