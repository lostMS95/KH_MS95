package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 준비
		int no = 9;
		int price = 5000;

		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "update product set price = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, no);

		int count = ps.executeUpdate();

		con.close();

		System.out.println("count = " + count);
		if (count > 0) {

			System.out.println("업데이트완료");
		} else {
			System.out.println("해당 상품 없음");
		}

	}
}
