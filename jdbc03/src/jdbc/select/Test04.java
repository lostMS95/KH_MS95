package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// member 조회하는 방법
		// 1. 애초에 구문에서 중요정보를 제외하고 조회하는 방법 (안정성↑)
		// 2. 전체 조회 후 원하는 정보만 출력 (확장성↑)

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		Scanner sc = new Scanner(System.in);

		System.out.println("아이디 입력 ");
		String id = sc.next();
		sc.close();

		String sql = "select * from member where member_id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
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
