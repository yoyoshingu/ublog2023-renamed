package com.sg.leoublog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class UblogExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public String globalExeptionHandler(Exception e) {
		return "<h1> 이런 예외발생 UblogExeptionHandler </h1>"
				+ "<br><h2>e.getMessage()</h2>";
	}

}
