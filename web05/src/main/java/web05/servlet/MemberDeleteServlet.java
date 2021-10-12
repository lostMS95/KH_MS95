package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;

@WebServlet(urlPatterns = "/member/delete.kh")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//입력 : member테이블 P.K
			String memberId = req.getParameter("id");
			
			//처리
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.delete(memberId);
			
			//출력
			resp.setCharacterEncoding("MS949");
			if (success) {
				resp.getWriter().println("회원 삭제 완료");
			} else {
				resp.getWriter().println("존재하지 않는 아이디");
			}
		} catch (Exception e) {
			resp.getWriter().println("error");
		}
	}
}
