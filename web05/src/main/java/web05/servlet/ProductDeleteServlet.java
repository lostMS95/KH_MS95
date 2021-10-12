package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;

@WebServlet(urlPatterns = "/product/delete.kh")
public class ProductDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {//Plan A
			//입력 : product 테이블의 Primary key
			int no = Integer.parseInt(req.getParameter("no"));
			
			//처리
			ProductDao productDao = new ProductDao();
			boolean success = productDao.delete(no);
			
			//출력
			resp.setCharacterEncoding("MS949");
			if (success) {
				resp.getWriter().println("해당 상품 삭제 완료");
			} else {
				resp.getWriter().println("해당 하는 상품번호가 없습니다");
			}
		} catch (Exception e) {//Plan B
			resp.getWriter().println("error");
		}

	}
}
