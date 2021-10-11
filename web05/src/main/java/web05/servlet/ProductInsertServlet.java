package web05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web05.beans.ProductDao;
import web05.beans.ProductDto;

@WebServlet(urlPatterns = "/product/insert.kh")
public class ProductInsertServlet extends HttpServlet {

	@Override

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : ProductDto(name, type, price, made, expire)
			
			ProductDto productDto = new ProductDto();
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));
			
			//처리
			ProductDao productDao = new ProductDao();
			productDao.insert(productDto);
			
			//출력
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("상품 등록 완료");
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();

		}
	}
}
