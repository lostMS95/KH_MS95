package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String id = "khuser1234";//회원ID
		String pw = "khuser12345";//기존PW
		String alterPw = "khuser12347";//변경할PW
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "update member set member_pw = ? where member_id = ? and member_pw = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, alterPw);
		ps.setString(2, id);
		ps.setString(3, pw);
		
		int count = ps.executeUpdate();
		con.close();
		
		if(count > 0) {
			System.out.println("변경 성공!");
		}
		else {
			System.out.println("변경 실패");
		}
	}
}
