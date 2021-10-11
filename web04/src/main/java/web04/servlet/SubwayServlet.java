package web04.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/subway.kh") // 등록
public class SubwayServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// req : 요청 객체. 사용자가 주문한 내용이 들어가 있음
			// resp : 응답 객체. 사용자에게 배송할 내용을 설정할 수 있음.

			LocalDate now = LocalDate.now();
			int birth = Integer.parseInt(req.getParameter("birth"));
			int year = now.getYear();
			int age = year - birth + 1;

//		if (age < 8 || age >= 65) {
//			resp.getWriter().println("요금 : 0원");
//		} else if (age >= 20) {
//			resp.getWriter().println("요금 : 1250원");
//		} else if (age >= 14) {
//			resp.getWriter().println("요금 : 720원");
//		} else {
//			resp.getWriter().println("요금 : 450원");
//		}
			int price;
			if (age < 8 || age >= 65) {
				price = 0;
			} else if (age >= 20) {
				price = 1250;
			} else if (age >= 14) {
				price = 720;
			} else {
				price = 450;
			}
			resp.setCharacterEncoding("ms949");
			resp.getWriter().println("나이 " + age + "세");
			resp.getWriter().println("요금 : " + price + "원");
		} catch (Exception e) {
			resp.getWriter().println("error");
		}
	}
}
