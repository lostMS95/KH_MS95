package com.kh.spring04;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LottoController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Set<Integer>set = new TreeSet<>();
		Random r = new Random();
		
		while(set.size() < 6) {
			set.add(r.nextInt(45)+1);
		}
		mv.addObject("lotto", set);
		
		mv.setViewName("/WEB-INF/views/lotto.jsp");
		return mv;
	}
}