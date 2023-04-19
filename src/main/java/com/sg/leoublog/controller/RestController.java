package com.sg.leoublog.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.sg.leoublog.domain.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@GetMapping("/ublog")
	public User httpGet() {
		User finduser= User.builder().id(1).username("ai").password("222").email("g@gmail.com").build();
		return finduser;
	}
}
