package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
//		return "/WEB-INF/views/home.jsp";//뷰.리.졸.버.전
		return "home";//뷰.리.졸.버.후
	}
}
