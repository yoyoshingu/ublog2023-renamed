package com.sg.leoublog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.leoublog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
