package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;

@WebServlet(urlPatterns = "/member/password.kh")
public class MemberChangePasswordServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 입력
//		String memberId = req.getParameter("id");
//		String memberPw = req.getParameter("pw");

		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(req.getParameter("id"));
		memberDto.setMemberPw(req.getParameter("pw"));
		String changePw = req.getParameter("changePw");
		try {
			// 처리
			resp.setCharacterEncoding("MS949");
			if (memberDto.getMemberPw().equals(changePw)) {// 현재비밀번호와 바꿀비밀번호가 같다면
				resp.getWriter().println("동일한 비밀번호로 변경 불가능");
			} else { // 현재비밀번호와 바꿀비밀번호가 다르다면
				MemberDao memberDao = new MemberDao();
				boolean success = memberDao.editPassword(memberDto, changePw);

				// 출력
				if (success) {
					resp.getWriter().println("비밀번호 변경 완료");
				} else {
					resp.getWriter().println("정보가 잘못되었습니다");
				}
			}
		} catch (Exception e) {
			resp.getWriter().println("error");
		}

	}
}
