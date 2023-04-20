package com.sg.leoublog.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.leoublog.domain.RoleType;
import com.sg.leoublog.domain.User;
import com.sg.leoublog.dto.ResponseDTO;
import com.sg.leoublog.exception.UblogException;
import com.sg.leoublog.repository.UserRepository;
import com.sg.leoublog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	

	
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		User findUser = userRepository.findById(id).orElseThrow(new Supplier<UblogException>() {
			public UblogException get() {
				return new UblogException(id + "회원없음");
			}
		});
		return findUser;
	}
	
	@GetMapping("/user/page/{page}")
	public @ResponseBody Page<User> getUserListPaging(@PathVariable int page){
		Pageable pageable = PageRequest.of(page,  2, Sort.Direction.DESC, "id", "username");
		return userRepository.findAll(pageable);
	}
	
	@PostMapping("/user")
	public @ResponseBody String insertUserold(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + " 회원가입 성공";
	}
	
	@GetMapping("/user/list")
	public @ResponseBody List<User> getUserList(){
		return userRepository.findAll();
	}
	
	@DeleteMapping("/user/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return id + " 번 회원 삭제 성공";
	}
	
	@PutMapping("/user")
	public @ResponseBody String updateUser(@RequestBody User user) {
		int report = user.getId();
		return report + "회원수정 성공" + user.toString();
//		User findUser = userRepository.findById(user.getId()).get();
//		findUser.setUsername(user.getUsername());
//		findUser.setPassword(user.getPassword());
//		findUser.setEmail(user.getEmail());
		
//		return report + "회원수정 성공";
	}
	
	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "user/insertUser";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user){
		
//		User findUser = userService.getUser(user.getUsername());
//		userService.insertUser(user);
//		return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공1 by UserController /auth/insertUser");
		
		User findUser = userService.getUser(user.getUsername());
		if(findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공1 by UserController /auth/insertUser");

		}
		else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님 이미 회원 by UserController /auth/insertUser");
		}
	}

}
