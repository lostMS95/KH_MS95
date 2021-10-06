package jdbc.select2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//member 단일조회(PRIMARY KEY : member_id)
		//= select * from member where member_id = ?
		
		//입력 - PK
		System.out.print("조회할 회원 아이디 : ");
		Scanner sc = new Scanner(System.in);
		String member_id = sc.next();
		sc.close();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {//있으면(1개)
			System.out.println("<해당 회원 정보>");
			System.out.print(rs.getString("member_id"));
			System.out.print("  /  ");
			System.out.print(rs.getString("member_nick"));
			System.out.print("  /  ");
			System.out.print(rs.getDate("member_birth"));
			System.out.print("  /  ");
			System.out.print(rs.getString("member_email"));
			System.out.print("  /  ");
			System.out.print(rs.getString("member_phone"));
			System.out.print("  /  ");
			System.out.print(rs.getDate("member_join"));
			System.out.print("  /  ");
			System.out.print(rs.getInt("member_point"));
			System.out.print("  /  ");
			System.out.println(rs.getString("member_grade"));
		}
		else {//없으면
			System.out.println("해당하는 회원이 없습니다.");
		}
	}
}
