package jdbc.select2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jdbc.util.JdbcUtils;

public class Test04 {
	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String member_id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String member_pw = sc.next();
		sc.close();

		Connection con = JdbcUtils.connect("kh", "kh");

		String sql = "select * from member where member_id = ?and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ps.setString(2, member_pw);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println(rs.getString("member_nick") + "님 로그인 성공!");
		} else {
			System.out.println("로그인 정보가 일치하지 않습니다.");
		}

		con.close();
	}
}
