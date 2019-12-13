package com.naver.webservice.web;

import com.naver.webservice.domain.PostsRepository;
import com.naver.webservice.dto.posts.PostsSaveRequestDto;
import com.naver.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long postPosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
