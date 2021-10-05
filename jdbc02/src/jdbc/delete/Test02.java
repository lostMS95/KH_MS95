package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 사용자에게 아이디(memberId)와 비밀번호(memberPw)를
		// 입력받아 일치하는 회원 정보를 삭제
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = sc.next();
		System.out.print("삭제할 패스워드 입력 : ");
		String pw = sc.next();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "delete from member where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

		ps.execute();

		con.close();
		System.out.println("삭제 완료!");
		}
		catch(Exception e) {
			System.out.println("문제발생");
		}
		}
}
