package com.naver.webservice.service;

import com.naver.webservice.domain.Posts;
import com.naver.webservice.domain.PostsRepository;
import com.naver.webservice.dto.posts.PostsMainResponseDto;
import com.naver.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void postsDtoSavePostsTable() {

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("kkarlong")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        postsService.save(dto);

        Posts posts = postsRepository.findAll().get(2);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void postFindAllDesc() {
        List<PostsMainResponseDto> posts = postsService.findAllDesc();

        assertThat(posts.get(0).getId()).isEqualTo(1L);
    }
}