package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns="/member/login.kh")
public class MemberLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : memberId, memberPw
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");
			
			//처리
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.select(memberId);
			
			//회원이 있는데 비밀번호까지 같다면 로그인이 성공한것으로 간주하고 싶다!
			boolean login = memberDto != null && memberDto.getMemberPw().equals(memberPw);
			
			if(login) {
				
				//세션 = 서버에서 사용자 정보를 관리하기 위한 단골수첩과 같은 저장소(Map 형태)
				//= 세션(단골수첩)에 사용자가 로그인 했음을 key=value 형태로 저장하면 이후에 확인이 가능
				//= 저장형태는 String, Object
				//= 서블릿에서는 req.getSession() 이라는 명령으로 접근이 가능
				//= 여기서는 가장 중요한 회원정보인 회원아이디를 logkey라는 이름으로 저장
				req.getSession().setAttribute("logkey",memberId);
				
				//resp.sendRedirect(req.getContextPath() + "/index.jsp");//절대
				//resp.sendRedirect("../index.jsp");//상대
				resp.sendRedirect("/home/index.jsp");
			}
			else {
				resp.sendRedirect("login.jsp?error");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
