package com.sg.leoublog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leoublog.domain.Post;
import com.sg.leoublog.dto.ResponseDTO;
import com.sg.leoublog.service.PostService;

@Controller
public class PostController {
//	@GetMapping({ "", "/" })
//	public String getPostList() {
//		return "ublogindex";
//	}
	
	@GetMapping("/auth/insertPost")
	public String insertPost() {
		return "insertPost";
	}
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post){
		post.setCnt(0);
		postService.insertPost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), "새로운포스트 등록");
	}
	
	@GetMapping({ "", "/" })
	public String getPostList(Model model) {
		model.addAttribute("postList", postService.getPostList());
		return "ublogindex";
	}
	
}
