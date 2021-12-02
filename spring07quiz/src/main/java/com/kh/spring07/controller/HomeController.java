package com.kh.spring07.controller;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring07.entity.StudentDto;

@Controller
public class HomeController {

	@RequestMapping("/")
//	public ModelAndView home() {
	public String home() {
//		return "/WEB-INF/views/home.jsp";//view resolver 적용 전
		return "home";//view resolver 적용 후
	}
	
	@RequestMapping("/dice")
	public ModelAndView dice() {
		ModelAndView mv = new ModelAndView();
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		
		mv.addObject("dice", dice);
//		mv.setViewName("/WEB-INF/views/dice.jsp");//view resolver 적용 전
		mv.setViewName("dice");//view resolver 적용 후
		return mv;
	}
	
	@RequestMapping("/dice2")
	public String dice2(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6) +1;
		
		model.addAttribute("dice", dice);
		
//		return "/WEB-INF/views/dice.jsp";
		return "dice";
	} 
	@RequestMapping("/lotto")
	public ModelAndView lotto() {
		ModelAndView mv = new ModelAndView();
		Set<Integer>set = new TreeSet<>();
		Random r = new Random();
		
		while(set.size() < 6) {
			set.add(r.nextInt(45)+1);
		}
		mv.addObject("lotto", set);
		mv.setViewName("lotto");
		return mv;
	}
	
	//파라미터를 기존 서블릿 처럼 수신할 경우는 HttpServletRequest를 선언하고 사용
	@RequestMapping("/subway")
	public String subway2(Model model, HttpServletRequest req) {
		int age=Integer.parseInt(req.getParameter("age"));
		
		int price;
		if(age >= 20)
			price = 1250;
		else if(age >= 14)
			price = 720;
		else 
			price = 0;
		model.addAttribute("price", price);
		
//		return "/WEB-INF/views/subway.jsp";
		return "subway";
	}
	
	//스프링에서 제공하는 자동 수신 기능을 이용하면 다양한 옵션 등을 설정할 수 있다.
	@RequestMapping("/subway2")
//	public String subway2(Model model, int age) P
//	public String subway2(Model model, @RequestParam int age) {
	public String subway2(Model model, @RequestParam(required = false, defaultValue = "20")int age ) {
		int price;
		if(age >= 20) 
			price = 1250;
		else if(age >= 14) 	
			price = 720;
		else 			
			price = 0;
		
		model.addAttribute("price", price);
		
//		return "/WEB-INF/views/subway.jsp";
		return "subway";
	}
	
	//스프링에서 제공하는 경로변수(Path variable) 방식
	//http://localhost:8080/spring07/subway3/20
	@RequestMapping("/subway3/{age}")
	public String subway3(Model model, @PathVariable int age) {
		int price;
		if(age >= 20)
			price = 1250;
		else if(age >= 14)
			price = 720;
		else 
			price = 0;
		model.addAttribute("price", price);
		
		return "subway";
	}
	//객체에 해당하는 정보가 파라미터로 전달될 경우의 처리
	//ex - http://localhost:8080/spring07/add?name=피카츄&score=90
	//[1] request를 이용해서 수신하는 방법
	//[2] requestParam을 이용하여 수신하는 방법
	// @RequestParam String name, @RequestParam int score
	//[3] @ModelAttribute 를 이용항 수신 하는 방법
	//    @ModelAttribute StudentDto studentDto
	//	  받을 수 있는 항목을 다 찾아서 자료형까지 맞춰서 수신
	@RequestMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto, Model model) {
		model.addAttribute("studentDto", studentDto);
		return "add";
	}
}