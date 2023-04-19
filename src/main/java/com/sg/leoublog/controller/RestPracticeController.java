package com.sg.leoublog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")

public class RestPracticeController {
	@RequestMapping("/hello")
	public String hello() {
		return "/hello Response , from spring Rest practice 15Feb2023 by Lee";
	}
	
	//	http://localhost:8080/api/get
	@GetMapping("/get")
	public String get() {
		return "/get Hello world, from spring Rest practice 15Feb2023 by Lee";
	}
	
	
	//http://localhost:8080/api/getchk/8848
	@GetMapping(value="/getchk/{variable}")
	public String getchk(@PathVariable String variable) { 
	
		return "/getchk Hello world, pathvariables: " + variable;
	}
	

	// http://localhost:8080/api/getparam?name=hjk&email=a@df.com
	@GetMapping(value="/getparam")
	public String getparam(@RequestParam String name, @RequestParam String email) {
		return "/getparam  name= " + name + ", input email = " + email;
	}
	
}
