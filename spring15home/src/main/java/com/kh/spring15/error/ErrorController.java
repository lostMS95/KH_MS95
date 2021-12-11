package com.kh.spring15.error;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *	전체 오류를 처리하는 도구
 *	- 내부에 @ExceptionHandler 를 배치하여 간섭 대상에서 발생한 오류를 인터셉트한다
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
//@ControllerAdvice(basePackages = {"com.kh.spring15.controller"})
public class ErrorController {
	
//	@ExceptionHandler(SQLException.class)
//	@ExceptionHandler(IOException.class)
//	@ExceptionHandler(RuntimeException.class)
	
	@ExceptionHandler(Exception.class)
	public String ex(Exception e) {
		//기록? 단순출력? 파일출력?
		System.err.println(e);
		return "error/500";
	}
}