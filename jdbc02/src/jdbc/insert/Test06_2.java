package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Test06_2 {
	public static void main(String[] args) {
		// 사용자에게 필요한 정보를 입력받아서 회원가입을 구현(member 테이블 사용)
		// 문제 없이 등록이 되었다면 마지막에 "회원가입 성공!" 이라는 메세지 출력
		// 문제가 생겼다면 "회원 가입 과정에서 오류가 발생했습니다" 라는 메세지 출력
		try {
			String memberId = "khuser1237";
			String memberPw = "khuser1237";
			String memberNick = "학생1237";
			String memberBirth = "1990-05-25";
			String memberEmail = "khuser1234@kh.com";
			String memberPhone = "010-1231-3453";

			// 처리
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

			// #1. 형식을 지정할 경우
			String sql1 = "insert into member(" + "member_id, " + "member_pw, " + "member_nick, " + "member_birth, "
					+ "member_email, " + "member_phone" + ") values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?)";

			// #2. 형식을 지정하지 않을 경우
			String sql2 = "insert into member values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 100, '준회원')";

			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, memberId);
			ps.setString(2, memberPw);
			ps.setString(3, memberNick);
			ps.setString(4, memberBirth);
			ps.setString(5, memberEmail);
			ps.setString(6, memberPhone);
			ps.execute();

			con.close();

			// 출력
			System.out.println("회원 가입이 완료되었습니다");
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.err.println("아이디 또는 닉네임이 사용중입니다");
		}
		catch (Exception e) {
			System.err.println("회원 가입 과정에서 오류가 발생했습니다");
		}

	}
}
