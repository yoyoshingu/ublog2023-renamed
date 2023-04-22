package com.sg.leoublog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.leoublog.domain.Post;
import com.sg.leoublog.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		post.setCnt(0);
		postRepository.save(post);
	}
	
	@Transactional(readOnly=true)
	public List<Post> getPostList(){
		return postRepository.findAll();
	}

}
