package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/detail.kh")
public class MemberDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// 입력 : member 테이블의 primary key - memberId(String)
			String memberId = req.getParameter("memberId");

			// 처리
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.select(memberId);

			// 출력
			resp.setCharacterEncoding("MS949");
			if (memberDto != null) {
				resp.getWriter().println(memberDto.getMemberId());
				resp.getWriter().println(memberDto.getMemberNick());
				resp.getWriter().println(memberDto.getMemberEmail());
				resp.getWriter().println(memberDto.getBirthDate());
				resp.getWriter().println(memberDto.getMemberPhone());
				resp.getWriter().println(memberDto.getMemberPoint());
				resp.getWriter().println(memberDto.getMemberGrade());
				resp.getWriter().println(memberDto.getMemberJoin());
			} else {
				resp.getWriter().println("존재하지 않는 회원 아이디");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
