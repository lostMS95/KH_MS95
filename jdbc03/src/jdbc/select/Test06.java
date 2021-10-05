package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//select * from menu where menu_price between ? and ?;
		
		//입력
		int price = 1500;
		int price2 = 3000;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "select * from menu where menu_price between ? and ?";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, price2);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getString("menu_name"));
			System.out.print("/");
			System.out.print(rs.getInt("menu_price"));
			System.out.print("/");
			System.out.println(rs.getString("menu_type"));
		}
		
		con.close();
		
	}
}
