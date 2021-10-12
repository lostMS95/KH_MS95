package web05.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;
import web05.beans.ProductDto;

//상품 목록 및 검색 서블릿
@WebServlet(urlPatterns = "/product/find.kh")
public class ProductFindServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : 항목, 검색어
			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");
			//처리
			boolean isSearch = column != null && !column.equals("") && keyword != null && !column.equals("");

			ProductDao productDao = new ProductDao();
				
			List<ProductDto> list;
			if (isSearch) {
				list = productDao.select(column, keyword);
			} else {
				list = productDao.select();
			}
			
			//출력
			resp.setCharacterEncoding("MS949");
			for (ProductDto productDto : list) {
				resp.getWriter().println(productDto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
