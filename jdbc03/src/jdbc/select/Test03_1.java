package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Test03_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//product 조회
		//= select * from product;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "select * from product";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
//			System.out.print(rs.getInt("no"));
//			System.out.print("/");
//			System.out.print(rs.getString("name"));
//			System.out.print("/");
//			System.out.print(rs.getString("type"));
//			System.out.print("/");
//			System.out.print(rs.getInt("price"));
//			System.out.print("/");
//			System.out.print(rs.getDate("made"));
//			System.out.print("/");
//			System.out.println(rs.getDate("expire"));
			System.out.println("데이터 발견!");
			int no = rs.getInt("no");//rs.getInt(1)
			String name = rs.getString("name");//rs.getString(2)
			String type = rs.getString("type");//rs.getString(3)
			int price = rs.getInt("price");//rs.getInt(4)
			String made = rs.getString("made");
			String expire = rs.getString("expire");
			
			System.out.println("no = " + no);
			System.out.println("name = " + name);
			System.out.println("type = " + type);
			System.out.println("price = " + price);
			System.out.println("made = " + made);
			System.out.println("expire = " + expire);
			
		}
		
		con.close();
		System.out.println("조회 완료");
		
		
		
	}
}
