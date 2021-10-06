package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("항목 입력 : ");
		String kind = sc.next();
		System.out.print("키워드 입력 : ");
		String keyword = sc.next();
		sc.close();
		
		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql =sql.replace("#1", kind);
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con  = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		
		while (rs.next()) {
			System.out.print(rs.getString("member_id"));
			System.out.print("	/	");
			System.out.print(rs.getString("member_nick"));
			System.out.print("	/	");
			System.out.println(rs.getString("member_grade"));
		}

		
		con.close();
		
	}
}
