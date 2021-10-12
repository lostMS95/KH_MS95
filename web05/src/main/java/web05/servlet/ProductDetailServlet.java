package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/detail.kh")
public class ProductDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : product테이블 primary key - no(int)
			int no = Integer.parseInt(req.getParameter("no"));

			// 처리
			ProductDao productDao = new ProductDao();
			ProductDto productDto = productDao.select(no);

			// 출력
			resp.setCharacterEncoding("MS949");
			if (productDto != null) {
				// 정보 출력
				resp.getWriter().println(productDto.getName());
				resp.getWriter().println(productDto.getType());
				resp.getWriter().println(productDto.getPrice());
				resp.getWriter().println(productDto.getMadeDate());
				resp.getWriter().println(productDto.getExpireDate());
			} else {
				resp.getWriter().println("찾으시는 번호의 상품이 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
