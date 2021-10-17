package web08.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web08.beans.ProductDao;
import web08.beans.ProductDto;

@WebServlet(urlPatterns = "/product/search.kh")//
public class ProductSearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : column(선택), keyword(선택) : 둘다 있으면 검색, 아니면 목록
			String column = req.getParameter("column");
			String keyword = req.getParameter("keyword");
			
			//처리 : ProductDao
			boolean search = column != null && keyword != null && !keyword.equals("");
			//List<ProductDto> list = 목록결과 or 검색결과;
			List<ProductDto>list;

			ProductDao productDao = new ProductDao();
			if(search) {
				list = productDao.select(column, keyword);
			}
			else {
				list = productDao.select();
			}
			
			//출력 : 리다이렉트 불가
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("데이터개수 : "+list.size());
			for (ProductDto productDto : list) {
				resp.getWriter().println("-----상품 목록----");
				resp.getWriter().println("상품번호 : " + productDto.getNo());
				resp.getWriter().println("상품명 : " + productDto.getName());
				resp.getWriter().println("상품유형 : " + productDto.getType());
				resp.getWriter().println("상품가격 : " + productDto.getPrice());
				resp.getWriter().println("제조일자 : " + productDto.getMadeDate());
				resp.getWriter().println("유통기한 : " + productDto.getExpireDate());
				resp.getWriter().println();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("error");
		}
	}
}
