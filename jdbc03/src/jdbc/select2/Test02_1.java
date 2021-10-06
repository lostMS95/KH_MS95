package jdbc.select2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.JdbcUtils;

public class Test02_1 {
	public static void main(String[] args) throws Exception {
		//exam 테이블 단일조회
		
		System.out.print("조회할 학생 아이디 : ");
		Scanner sc = new Scanner(System.in);
		int exam_id = sc.nextInt();
		sc.close();
		
		Connection con = JdbcUtils.connect("kh", "kh");
		
		String sql = "select * from exam where exam_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, exam_id);
		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {
			System.out.println("<해당 학생 시험정보>");
			System.out.print(rs.getInt("exam_id"));
			System.out.print("   /   ");
			System.out.print(rs.getString("student"));
			System.out.print("   /   ");
			System.out.print(rs.getString("subject"));
			System.out.print("   /   ");
			System.out.print(rs.getString("type"));
			System.out.print("   /   ");
			System.out.println(rs.getInt("score"));
		}
		else {
			System.out.println("해당하는 학생이 없습니다.");
		}
		
	}
}
