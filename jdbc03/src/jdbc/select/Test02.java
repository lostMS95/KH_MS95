package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//exam 테이블 조회
		//= select * from exam;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "select * from exam";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt("exam_id"));
			System.out.print("/");
			System.out.print(rs.getString("student"));
			System.out.print("/");
			System.out.print(rs.getString("subject"));
			System.out.print("/");
			System.out.print(rs.getString("type"));
			System.out.print("/");
			System.out.println(rs.getInt("score"));
			
		}
		
		con.close();
		System.out.println("조회 완료");
		
	}
}
