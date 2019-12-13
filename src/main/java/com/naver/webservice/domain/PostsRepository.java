package com.naver.webservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.Id DESC")
    Stream<Posts> findAllDesc();
}
