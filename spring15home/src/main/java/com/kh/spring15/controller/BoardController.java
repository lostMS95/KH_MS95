package com.kh.spring15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kh.spring15.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//게시글 목록
	@RequestMapping("/list")
		public String list(Model model) throws Exception {
		
		model.addAttribute("list",boardService.list());
		return "board/list";
	}
	
}