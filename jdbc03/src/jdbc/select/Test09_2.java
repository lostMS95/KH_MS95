package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test09_2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Q : product테이블에서 원하는 항목에 맞는 검사를 수행
		// = 원하는 항목은 이름, 분류

		// 입력
		String kind = "name";// 검색할 컬럼명
		String keyword = "포";// 검색할 키워드

		String sql = "select * from product where instr(#1 , ?) > 0";
		sql = sql.replace("#1", kind);
		

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print(" / ");
			System.out.print(rs.getString("type"));
			System.out.print(" / ");
			System.out.print(rs.getInt("price"));
			System.out.println();
		}
			con.close();

	}
}
