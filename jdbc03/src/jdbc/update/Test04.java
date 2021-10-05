package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String id = "khuser1234";//확인용ID
		String pw = "khuser12347";//확인용PW
		String nick = "바꿀내용";//변경할nickname
		String birth = "1995-07-15";//변경할 생년월일
		String email = "rmsdn323@naver.com";//변경할 이메일
		String phone = "010-8366-3755";//변경할 전화번호
		
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		String sql = "update member set member_nick = ?,"
				+ "member_birth = to_date(?, 'YYYY-MM-DD'),"
				+ "member_email = ?, member_phone = ?  "
				+ "where member_id = ? and member_pw = ?";
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, nick);
		ps.setString(2, birth);
		ps.setString(3, email);
		ps.setString(4, phone);
		ps.setString(5, id);
		ps.setString(6, pw);
		
		int count = ps.executeUpdate();
		con.close();
		
		if(count > 0) {
			System.out.println("정보가 성공적으로 변경되었습니다");
		}
		else {
			System.out.println("정보 변경에 실패했습니다. 인증 정보가 일치하지 않습니다");
		}
	}
}
