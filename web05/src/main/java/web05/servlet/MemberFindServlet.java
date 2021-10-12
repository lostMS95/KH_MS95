package web05.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.MemberDao;
import web05.beans.MemberDto;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/member/find.kh")
public class MemberFindServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");

			boolean isSearch = column != null && !column.equals("") && 
					column != null && !column.equals("");

			MemberDao memberDao = new MemberDao();
			List<MemberDto> list;

			if (isSearch) {
				list = memberDao.select(column, keyword);
			} else {
				list = memberDao.select();
			}
			resp.setCharacterEncoding("MS949");
			for (MemberDto memberDto : list) {
				resp.getWriter().println(memberDto.getMemberId());
				resp.getWriter().println(memberDto.getMemberNick());
				resp.getWriter().println(memberDto.getMemberBirth());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
