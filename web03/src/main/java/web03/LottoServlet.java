package web03;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lotto.kh")
public class LottoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Set<Integer> lotto = new TreeSet<>();
				
				Random r = new Random();
				while(lotto.size( ) < 6) {
					int number =	r.nextInt(45) +1;
					lotto.add(number);
				}
				resp.getWriter().println(lotto);
				
	}
}
