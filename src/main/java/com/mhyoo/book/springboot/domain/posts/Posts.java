package com.mhyoo.book.springboot.domain.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor // 이 두개는 롬북의 어노테이션, 기본 생성자 자동 추가
@Entity
//JPA의 어노테이션, 테이블과 링크될 클래스임을 의미함.
public class Posts extends BaseTimeEntity{
    @Id // 해당 테이블의 PK 필드를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 필드 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
