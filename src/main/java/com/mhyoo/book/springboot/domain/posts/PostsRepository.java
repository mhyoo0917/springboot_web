package com.mhyoo.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{


//    @Query(value = "SELECT * FROM Posts p ORDER BY p.ID DESC")
    @Query(value = "SELECT * FROM Posts p ORDER BY p.ID DESC", nativeQuery = true)
    List<Posts> findAllDesc();

}
