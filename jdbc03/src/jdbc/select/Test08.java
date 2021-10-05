package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String id = "test999";
		String nick = "바";

		String sql = "select * from member where member_id like ? or member_nick like ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nick + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("member_id"));
			System.out.print("/");
			System.out.print(rs.getString("member_nick"));
			System.out.print("/");
			System.out.print(rs.getDate("member_birth"));
			System.out.print("/");
			System.out.print(rs.getString("member_email"));
			System.out.print("/");
			System.out.print(rs.getString("member_phone"));
			System.out.print("/");
			System.out.print(rs.getDate("member_join"));
			System.out.print("/");
			System.out.print(rs.getInt("member_point"));
			System.out.print("/");
			System.out.println(rs.getString("member_grade"));
		}

		con.close();
		System.out.println("조회 완료");
	}
}
