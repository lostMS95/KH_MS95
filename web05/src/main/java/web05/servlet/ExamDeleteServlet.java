package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ExamDao;

@WebServlet(urlPatterns = "/exam/delete.kh")
public class ExamDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int examId = Integer.parseInt(req.getParameter("id"));
			ExamDao examDao = new ExamDao();
			boolean success = examDao.delete(examId);

			resp.setCharacterEncoding("MS949");
			if (success) {
				resp.getWriter().println("시험 정보 삭제 완료");
			} else {
				resp.getWriter().println("존재하지 않는 시험지 번호");
			}
		} catch (Exception e) {
			resp.getWriter().println("error");
		}

	}
}
