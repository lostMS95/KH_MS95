package jdbc.select2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jdbc.util.JdbcUtils;

public class Test04_1 {
	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String member_id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String member_pw = sc.next();
		sc.close();

		Connection con = JdbcUtils.connect("kh", "kh");

		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {//아이디가 있으면
			String dbPassword = rs.getString("member_pw");
			if(member_pw.equals(dbPassword)) {//비밀번호가 일치하면
				System.out.println("로그인 성공");
			}
			else {//비밀번호가 일치하지 않으면
				System.out.println("비밀번호 불일치");
			}
		}
		else {//아이디가 없으면
			System.out.println("아이디 없음");
		}
		
		con.close();
	}
}
