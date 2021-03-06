package jdbc.select2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Q : 번호(no)를 이용한 상품정보 조회(단일조회)
		// ex : 3번 상품의 정보를 출력
		// 예상되는 결과는 (1) 아예 없거나 (2) 한 개 나오거나

		// 입력
		int no = 30;

		// 처리 - 기존의 목록 조회방식처럼 구현
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "select * from product where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {// 있으면
			System.out.print(rs.getInt("no"));
			System.out.print("  /  ");
			System.out.print(rs.getString("name"));
			System.out.print("  /  ");
			System.out.println(rs.getInt("price"));
		} else {// 없으면
			System.out.println("해당 번호의 상품이 없습니다.");
		}

		con.close();

	}
}
