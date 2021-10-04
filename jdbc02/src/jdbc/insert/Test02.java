package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String menuName = "오므라이스";
		String menuType = "식사";
		int menuPrice = 8500;

		// Q : 위 변수에 저장된 값이 menu 테이블에 insert 될 수 있도록 JDBC 구문을 작성해보세요.
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "INSERT INTO menu(menu_name, menu_price, menu_type)" + "VALUES('" + menuName + "', " + menuPrice
				+ ", '" + menuType + "')";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.execute();
		con.close();
		System.out.println("실행 완료!");
	}
}
