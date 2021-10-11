package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/join.kh")
public class MemberJoinServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {// 멀쩡한 경우 : Plan A

			// 입력 : MemberDto(memberId, memberPw, memberNick, memberEmail, memberBirth,
			// memberPhone
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("id"));
			memberDto.setMemberPw(req.getParameter("pw"));
			memberDto.setMemberNick(req.getParameter("nick"));
			memberDto.setMemberBirth(req.getParameter("birth"));
			memberDto.setMemberEmail(req.getParameter("email"));
			memberDto.setMemberPhone(req.getParameter("phone"));

			// 처리
			MemberDao memberDao = new MemberDao();
			memberDao.insert(memberDto);

			// 출력
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("회원 가입 완료");

		} catch (Exception e) {// 이상한 경우 : Plan B
			resp.getWriter().println("error");
		}
	}

}
