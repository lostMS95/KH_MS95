package com.kh.spring21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//데이터를 반환하는 컨트롤러를 만들려면 매 요청마다 @ReponseBody를 추가해야 한다.
//@RestController를 이용하면 모든 요청이 @ResponseBody 처리된다.

@RestController
public class DataController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/data1")
	public int data1() {
		return 100;
	}
	
}