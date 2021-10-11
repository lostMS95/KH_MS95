package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/edit.kh")
public class MemberEditServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : MemberDto
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("id"));
			memberDto.setMemberPw(req.getParameter("pw"));
			memberDto.setMemberNick(req.getParameter("nick"));
			memberDto.setMemberBirth(req.getParameter("birth"));
			memberDto.setMemberEmail(req.getParameter("email"));
			memberDto.setMemberPhone(req.getParameter("phone"));

			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.update(memberDto);

			if (success) {
				resp.setCharacterEncoding("MS949");
				resp.getWriter().println("회원 정보 변경 완료");
			} else {
				resp.setCharacterEncoding("MS949");
				resp.getWriter().println("존재하지 않는 회원 아이디");
			}
		} catch (Exception e) {
			resp.getWriter().println("error");
			e.printStackTrace();
		}

	}
}
