package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Q : 상품번호(no)를 입력받아 상품정보(product) 삭제
		// 입력
		int no = 10;

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "delete product where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, no);

		ps.execute();

		con.close();

		// 결과
		System.out.println("삭제 완료");

	}
}
