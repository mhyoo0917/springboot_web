package com.mhyoo.book.springboot.web;

import com.mhyoo.book.springboot.service.posts.PostsService;
import com.mhyoo.book.springboot.web.dto.PostsResponseDto;
import com.mhyoo.book.springboot.web.dto.PostsSaveRequestDto;
import com.mhyoo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable(name = "id") Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable(name = "id") Long id){
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable(name = "id") Long id){
        return postsService.findById(id);
    }


}
