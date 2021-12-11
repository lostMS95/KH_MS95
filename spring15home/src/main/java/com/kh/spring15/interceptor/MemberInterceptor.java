package com.kh.spring15.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *	(Q) 회원 기능에 회원만 접근할 수 있도록 인터셉터를 구현하세요 
 */
public class MemberInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String memberId = (String)request.getSession().getAttribute("ses");
		boolean login = memberId != null;
		
		if(login) {//회원이라면 --> 통과
			return true;
		}
		else {//회원이 아니라면 --> 
			System.out.println("차단하겠습니다.");
			//response.sendRedirect(request.getContextPath()+"/member/login");
			response.sendError(401);
			return false;
		}
	}
}