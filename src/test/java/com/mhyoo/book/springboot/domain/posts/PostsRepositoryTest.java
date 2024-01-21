package com.mhyoo.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 데이터베이스 자동 실행
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsrepository;

    @After // junit 단위테스트가 끝날때마다 수행되는 메소드 지정
    public void cleanup(){
        postsrepository.deleteAll();
    }

    @Test
    public void 게시글_불러오기(){
        String title = "테스트 게시물";
        String content = "테스트 본문";

        postsrepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("mhyoo@daum.net")
                .build());

        List<Posts> postsList = postsrepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
