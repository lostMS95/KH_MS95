package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//menu 테이블을 조회하는 프로그램
		
		//입력없음
		
		//처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "select * from menu";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery(); 
		//실행 시킨 뒤 발생하는 결과집합(ResultSet)을 반환하라!
		//= 결과집합은 데이터가 복사되어 저장된 형태가 아니라 영상통화처럼 참조만 가능한 형태이다
		//= 따라서 연결이 끊어지면 사용이 불가능하다
		
		//사용할 수 있는 명령
		//1. rs.next() : 다음 줄로 포커스를 이동하는 명령(true/false 반환)
		//2. rs.get~~() : 포커스가 위치한 줄의 컬럼을 읽는 명령
		//while(다음줄에 데이터가 있다면) {
		//		데이터를 꺼내세요(출력을 하든가 말든가)
		//}
		//while(true) {
		//		if(다음줄에 데이터가 없다면) break;
		//		else 데이터를 꺼내세요
		//}
		while(rs.next()) {
		System.out.print(rs.getString("menu_name"));
		System.out.print("/");
		System.out.print(rs.getInt("menu_price"));
		System.out.print("/");
		System.out.println(rs.getString("menu_type"));
		
		
		}
		con.close();
		
		
		System.out.println("조회 완료");
	}
}