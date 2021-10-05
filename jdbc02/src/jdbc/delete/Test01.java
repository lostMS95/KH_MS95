package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 사용자에게 상품번호(no)를 입력받아서
		// product 테이블에서 해당하는 상품번호 데이터를 삭제
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품번호 입력 : ");
		int no = sc.nextInt();
		sc.close();

		// 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "delete from product where no =  ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);

		ps.execute();

		con.close();
		System.out.println("삭제 완료!");

	}
}
