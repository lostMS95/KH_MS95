package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 준비
		int no = 1;// 고칠번호
		String name = "빠삐코";// 바꿀이름
		String type = "아이스크림";// 바꿀분류
		int price = 5000;// 바꿀가격
		String made = "2005-05-01";// 바꿀 제조일자
		String expire = "2010-10-01";// 바꿀 유통기한

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "update product set name = ?, type = ?," + "price = ?, made = to_date(?,'YYYY-MM-DD'), "
				+ "expire = to_date(?, 'YYYY-MM-DD') where no = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, price);
		ps.setString(4, made);
		ps.setString(5, expire);
		ps.setInt(6, no);

		int count = ps.executeUpdate();

		con.close();

		if (count > 0) {
			System.out.println("상품 정보 변경이 완료되었습니다");
		} else {
			System.out.println("상품 번호가 존재하지 않습니다");
		}
	}
}
